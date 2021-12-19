package com.yucelt.data.repository

import com.yucelt.base.domain.Resource
import com.yucelt.common.util.Constant
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
        try {
            val cachedData = appDao.getCachedWeatherByCityName(cityName)

            cachedData?.let { data ->
                emit(Resource.loading(data.mapEntityToModel()))
            } ?: emit(Resource.loading())

            val response = apiService.getWeatherByCityName(cityName)
            if (response != null) {
                appDao.saveWeatherByCityName(response.mapDtoToEntity())
                emit(Resource.success(response.mapDtoToModel()))
            } else {
                cachedData?.let { data ->
                    emit(Resource.success(data.mapEntityToModel()))
                } ?: emit(Resource.error(Constant.EMPTY_DATA))
            }
        } catch (throwable: Throwable) {
            emit(Resource.error(throwable.localizedMessage))
        }

    }

    override suspend fun saveFavoriteCity(favoriteCity: FavoriteCity?) = flow {
        try {
            emit(Resource.loading())
            val data = appDao.saveFavoriteCity(favoriteCity.mapModelToEntity())
            data?.let {
                emit(Resource.success(it))
            } ?: emit(Resource.error(Constant.EMPTY_DATA))
        } catch (throwable: Throwable) {
            emit(Resource.error(throwable.localizedMessage))
        }
    }

    override suspend fun getAllFavoriteCities() = flow {
        try {
            emit(Resource.loading())
            val data = appDao.getAllFavoriteCities()
            data?.let {
                emit(Resource.success(it.mapListEntityToListModel()))
            } ?: emit(Resource.error(Constant.EMPTY_LIST))
        } catch (throwable: Throwable) {
            emit(Resource.error(throwable.localizedMessage))
        }
    }

    override suspend fun deleteFavoriteCity(id: Int?) = flow {
        try {
            emit(Resource.loading())
            val data = appDao.deleteFavoriteCity(id)
            data?.let {
                emit(Resource.success(it))
            } ?: emit(Resource.error(Constant.EMPTY_DATA))
        } catch (throwable: Throwable) {
            emit(Resource.error(throwable.localizedMessage))
        }
    }
}