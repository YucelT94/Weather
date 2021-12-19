package com.yucelt.data.repository

import com.yucelt.base.domain.Resource
import com.yucelt.data.local.dao.AppDao
import com.yucelt.data.mapper.*
import com.yucelt.data.remote.ApiService
import com.yucelt.domain.model.FavoriteCity
import com.yucelt.domain.repository.DataRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DataRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val appDao: AppDao
) : DataRepository {

    override suspend fun getWeatherByCityName(cityName: String?) = flow {
        val cachedData = appDao.getCachedWeatherByCityName(cityName).mapEntityToModel()
        emit(Resource.loading(cachedData))
        try {
            val response = apiService.getWeatherByCityName(cityName)
            if (response != null) {
                appDao.saveWeatherByCityName(response.mapDtoToEntity())
                emit(Resource.success(response.mapDtoToModel()))
            } else {
                emit(Resource.success(cachedData))
            }
        } catch (throwable: Throwable) {
            emit(Resource.error(throwable.localizedMessage))
        }

    }

    override suspend fun saveFavoriteCity(favoriteCity: FavoriteCity?) = flow {
        try {
            emit(Resource.loading())
            val data = appDao.saveFavoriteCity(favoriteCity.mapModelToEntity())
            if (data == null) {
                emit(Resource.error("Empty List"))
            } else {
                emit(Resource.success(data))
            }
        } catch (throwable: Throwable) {
            emit(Resource.error(throwable.localizedMessage))
        }
    }

    override suspend fun getAllFavoriteCities() = flow {
        try {
            emit(Resource.loading())
            val data = appDao.getAllFavoriteCities()
            if (data.isNullOrEmpty()) {
                emit(Resource.error("Empty List"))
            } else {
                emit(Resource.success(data.mapListEntityToListModel()))
            }
        } catch (throwable: Throwable) {
            emit(Resource.error(throwable.localizedMessage))
        }
    }

    override suspend fun deleteFavoriteCity(id: Int?) = flow {
        emit(Resource.loading(appDao.deleteFavoriteCity(id)))
    }
}