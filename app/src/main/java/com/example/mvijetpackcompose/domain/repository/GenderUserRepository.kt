package com.example.mvijetpackcompose.domain.repository

import com.example.mvijetpackcompose.domain.model.GenderUser
import kotlinx.coroutines.flow.Flow

interface GenderUserRepository {
    fun getGenderUser(name: String): Flow<GenderUser>
}