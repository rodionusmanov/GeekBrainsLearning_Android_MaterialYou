package com.example.materialyou.utils

import android.R
import android.util.TypedValue
import com.example.materialyou.model.dataTransferObject.PODDataTransferObject


fun convertToHdUrl(podDataTransferObject: PODDataTransferObject): String {
    return podDataTransferObject.hdurl
}
