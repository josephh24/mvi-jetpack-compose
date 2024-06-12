package com.example.mvijetpackcompose.data.network.repository

import com.example.mvijetpackcompose.data.di.IoDispatcher
import com.example.mvijetpackcompose.data.network.api.GenderApi
import com.example.mvijetpackcompose.data.network.model.GenderUserResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NetworkDataSourceImpl @Inject constructor(
    private val api: GenderApi,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
): NetworkDataSource {
    override suspend fun fetchNetworkGenderUser(name: String): GenderUserResponse {
        return withContext(dispatcher) {
            api.fetchGenderUser(name)
        }
    }
}