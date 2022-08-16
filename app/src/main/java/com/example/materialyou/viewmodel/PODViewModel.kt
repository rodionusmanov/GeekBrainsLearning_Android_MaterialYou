package com.example.materialyou.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.materialyou.BuildConfig
import com.example.materialyou.model.IRepository
import com.example.materialyou.model.IUniversalCallback
import com.example.materialyou.model.RetrofitPODImpl
import java.io.IOException

class PODViewModel(
    private val liveData: MutableLiveData<PODViewModelAppState> = MutableLiveData<PODViewModelAppState>()
) : ViewModel() {

    private val retrofitPODImpl : IRepository = RetrofitPODImpl()

    fun getLiveData(): MutableLiveData<PODViewModelAppState> {
        return liveData
    }

    fun getPictureHD(){
        liveData.value = PODViewModelAppState.Loading
        retrofitPODImpl.getPictureOfTheDay(BuildConfig.NASA_API_KEY, callback)
    }

    private val callback = object : IUniversalCallback {
        override fun onResponse(string: String) {
            liveData.postValue(PODViewModelAppState.Success(string))
        }

        override fun onFailure(e: IOException) {
            liveData.postValue(PODViewModelAppState.Error(e))
        }

    }
}