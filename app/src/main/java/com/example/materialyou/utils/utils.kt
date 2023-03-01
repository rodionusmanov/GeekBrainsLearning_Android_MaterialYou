package com.example.materialyou.utils

import com.example.materialyou.R
import com.example.materialyou.model.dataTransferObject.PODDataTransferObject
import com.example.materialyou.view.notesRecyclerView.Data
import com.example.materialyou.view.notesRecyclerView.TYPE_HEADER_PICTURE
import com.example.materialyou.view.notesRecyclerView.TYPE_STANDART

fun convertToHdUrl(podDataTransferObject: PODDataTransferObject): String {
    return podDataTransferObject.hdurl
}

fun isValidSearch(text: String?): Boolean {
    if (text.equals("") || text.equals(null)) {
        return false
    } else {
        return true
    }}


fun setDefaultNotesData() =
    arrayListOf(
        Data(TYPE_STANDART, "NOTE 1", "description 1", R.drawable.sun, false),
        Data(TYPE_STANDART, "NOTE 2", "description 2", R.drawable.mercury, false),
        Data(
            TYPE_HEADER_PICTURE, "NOTE 3", "description 3", R.drawable.earth, false
        ),
        Data(
            TYPE_STANDART, "NOTE 4", "description 4", R.drawable.mars, false
        )
    )

fun nullValidator(text: String?): String? {
    if (text.equals(null)) {
        return null
    } else {
        return text
    }
}