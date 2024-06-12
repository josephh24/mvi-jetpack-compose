package com.example.mvijetpackcompose.data.network.repository

import com.example.mvijetpackcompose.data.network.model.GenderUserResponse

interface NetworkDataSource {

    suspend fun fetchNetworkGenderUser(name: String): GenderUserResponse
}