package com.example.mvijetpackcompose.ui

sealed class GenderEvent {
    data class ShowToast(val message: String): GenderEvent()
}