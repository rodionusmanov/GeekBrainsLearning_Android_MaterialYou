package com.example.materialyou.model

import java.io.IOException

interface IRepository {
    fun getPictureOfTheDay(apikey : String, callback: IUniversalCallback)
}

interface IUniversalCallback {
    fun onResponse(string: String)
    fun onFailure(e: IOException)
}