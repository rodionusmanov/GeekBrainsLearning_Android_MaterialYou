package com.example.materialyou.utils

import com.example.materialyou.model.dataTransferObject.PODDataTransferObject

fun convertToHdUrl(podDataTransferObject: PODDataTransferObject): String {
    return podDataTransferObject.hdurl
}

fun isValidSearch(text: String?): Boolean {
    if (text.equals("") || text.equals(null)) {
        return false
    } else {
        return true
    }
}
