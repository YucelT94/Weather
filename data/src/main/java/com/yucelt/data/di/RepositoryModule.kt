package com.yucelt.data.di

import com.yucelt.data.repository.DataRepositoryImpl
import com.yucelt.domain.repository.DataRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindApiRepository(apiDataRepositoryImpl: DataRepositoryImpl): DataRepository
}