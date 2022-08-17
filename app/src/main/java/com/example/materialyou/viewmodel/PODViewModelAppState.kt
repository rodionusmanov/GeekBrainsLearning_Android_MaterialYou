package com.example.materialyou.viewmodel

import com.example.materialyou.model.dataTransferObject.PODDataTransferObject

sealed class PODViewModelAppState {
    data class Success(val podDataTransferObject: PODDataTransferObject) : PODViewModelAppState()
    data class Error(val error : Any) : PODViewModelAppState()
    object Loading : PODViewModelAppState()
}