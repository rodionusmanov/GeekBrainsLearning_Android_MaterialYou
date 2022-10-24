package com.example.materialyou.view.notesRecyclerView

import com.example.materialyou.R

const val TYPE_STANDART = 0
const val TYPE_HEADER_PICTURE = 1
const val NUMBER_OF_TYPES = 2

data class Data(
    var type: Int = TYPE_STANDART,
    var headerText: String = "Header",
    var descriptionText: String = "Description",
    var drawableRes: Int = R.drawable.notes_icon,
    var editNote: Boolean = true
) {
}
