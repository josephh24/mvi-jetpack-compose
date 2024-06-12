package com.example.mvijetpackcompose.data.di

import com.example.mvijetpackcompose.data.repository.GenderUserRepositoryImpl
import com.example.mvijetpackcompose.domain.repository.GenderUserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindGenderUserRepository(impl: GenderUserRepositoryImpl): GenderUserRepository
}