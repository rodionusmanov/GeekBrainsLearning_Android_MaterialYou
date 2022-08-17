package com.example.materialyou.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.materialyou.BuildConfig
import com.example.materialyou.model.IRepository
import com.example.materialyou.model.IUniversalCallback
import com.example.materialyou.model.RetrofitPODImpl
import com.example.materialyou.model.dataTransferObject.PODDataTransferObject
import java.io.IOException

class PODViewModel(
    private val liveData: MutableLiveData<PODViewModelAppState> = MutableLiveData<PODViewModelAppState>()
) : ViewModel() {

    private val retrofitPODImpl : IRepository = RetrofitPODImpl()

    fun getLiveData(): MutableLiveData<PODViewModelAppState> {
        return liveData
    }

    fun getInfoFromServer(){
        liveData.value = PODViewModelAppState.Loading
        retrofitPODImpl.getPictureOfTheDay(BuildConfig.NASA_API_KEY, callback)
    }

    private val callback = object : IUniversalCallback {
        override fun onResponse(podDataTransferObject: PODDataTransferObject) {
            liveData.postValue(PODViewModelAppState.Success(podDataTransferObject))
        }

        override fun onFailure(e: IOException) {
            liveData.postValue(PODViewModelAppState.Error(e))
        }

    }
}