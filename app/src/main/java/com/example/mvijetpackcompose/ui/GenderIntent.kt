package com.example.mvijetpackcompose.ui

sealed class GenderIntent {
    data class SearchGenderUser(val name: String): GenderIntent()
}