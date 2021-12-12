package com.yucelt.data.di

import com.yucelt.data.datasource.ApiDataRepository
import com.yucelt.domain.repository.ApiRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindApiRepository(apiDataRepository: ApiDataRepository): ApiRepository
}