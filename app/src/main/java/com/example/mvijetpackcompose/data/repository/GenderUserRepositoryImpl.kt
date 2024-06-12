package com.example.mvijetpackcompose.data.repository

import com.example.mvijetpackcompose.data.local.entity.asExternalModel
import com.example.mvijetpackcompose.data.local.repository.LocalDatabaseResource
import com.example.mvijetpackcompose.data.network.model.asEntity
import com.example.mvijetpackcompose.data.network.repository.NetworkDataSource
import com.example.mvijetpackcompose.domain.model.GenderUser
import com.example.mvijetpackcompose.domain.repository.GenderUserRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.retryWhen
import kotlinx.coroutines.flow.take
import javax.inject.Inject

class GenderUserRepositoryImpl @Inject constructor(
    private val localDatabaseResource: LocalDatabaseResource,
    private val networkDataSource: NetworkDataSource
): GenderUserRepository {
    override fun getGenderUser(name: String): Flow<GenderUser> {
        return localDatabaseResource
            .getGenderUserEntity(name)
            .map { genderUserEntity ->
                delay(200)
                genderUserEntity.asExternalModel()
            }
            .retryWhen { cause, attempt ->
                if (cause is NullPointerException && attempt < 1) {
                    fetchGenderUser(name)
                    true
                } else {
                    false
                }
            }
            .take(1)
    }

    private suspend fun fetchGenderUser(name: String): GenderUser {
        return networkDataSource.fetchNetworkGenderUser(name)
            .asEntity()
            .also { localDatabaseResource.saveGenderUserEntity(it) }
            .asExternalModel()
    }
}