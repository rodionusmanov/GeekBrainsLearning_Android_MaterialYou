package com.example.materialyou.model

import com.example.materialyou.model.dataTransferObject.PODDataTransferObject
import java.io.IOException

interface IRepository {
    fun getPictureOfTheDay(apikey : String, callback: IUniversalCallback)
}

interface IUniversalCallback {
    fun onResponse(podDataTransferObject: PODDataTransferObject)
    fun onFailure(e: IOException)
}