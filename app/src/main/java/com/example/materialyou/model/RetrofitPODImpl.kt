package com.example.materialyou.model

import com.example.materialyou.BuildConfig
import com.example.materialyou.model.dataTransferObject.PODDataTransferObject
import com.example.materialyou.utils.convertToHdUrl
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitPODImpl : IRepository{

    private val retrofitImpl = Retrofit.Builder()

    override fun getPictureOfTheDay(apikey: String, callback: IUniversalCallback) {
        retrofitImpl.baseUrl("https://api.nasa.gov/")
        retrofitImpl.addConverterFactory(
            GsonConverterFactory.create(GsonBuilder().setLenient().create())
        )
        val api = retrofitImpl.build().create(PODAPI::class.java)
        api.getPictureOfTheDay(BuildConfig.NASA_API_KEY).enqueue(object : Callback<PODDataTransferObject>{
            override fun onResponse(
                call: Call<PODDataTransferObject>,
                response: Response<PODDataTransferObject>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    callback.onResponse(response.body()!!)
                }
            }

            override fun onFailure(call: Call<PODDataTransferObject>, t: Throwable) {
//                TODO("Not yet implemented")
            }

        })
    }

}