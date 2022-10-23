package com.example.materialyou.view.notesRecyclerView

const val TYPE_STANDART = 1
const val TYPE_HEADER_PICTURE = 2

data class Data(val type :Int = TYPE_STANDART, val headerText: String = "Header", val descriptionText: String = "Description") {
}