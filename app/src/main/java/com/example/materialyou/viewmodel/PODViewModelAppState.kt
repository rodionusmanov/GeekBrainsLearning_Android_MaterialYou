package com.example.materialyou.viewmodel

sealed class PODViewModelAppState {
    data class Success(val hdurl : String) : PODViewModelAppState()
    data class Error(val error : Any) : PODViewModelAppState()
    object Loading : PODViewModelAppState()
}