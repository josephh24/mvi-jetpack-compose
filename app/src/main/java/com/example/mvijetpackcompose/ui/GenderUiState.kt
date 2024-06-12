package com.example.mvijetpackcompose.ui

import com.example.mvijetpackcompose.domain.model.GenderUser

data class GenderUiState(
    val genderUser: GenderUser? = null,
    val isLoading: Boolean = false
)