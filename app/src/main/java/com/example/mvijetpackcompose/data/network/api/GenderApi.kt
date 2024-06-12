package com.example.mvijetpackcompose.data.network.api

import com.example.mvijetpackcompose.data.network.model.GenderUserResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GenderApi {

    @GET("/")
    suspend fun fetchGenderUser(@Query("name") name: String): GenderUserResponse
}