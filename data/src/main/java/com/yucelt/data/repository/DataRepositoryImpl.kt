package com.yucelt.data.repository

import com.yucelt.data.local.dao.AppDao
import com.yucelt.data.mapper.mapDtoToModel
import com.yucelt.data.mapper.mapListEntityToListModel
import com.yucelt.data.mapper.mapModelToEntity
import com.yucelt.data.remote.ApiService
import com.yucelt.domain.model.FavoriteCity
import com.yucelt.domain.repository.DataRepository
import javax.inject.Inject

class DataRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val appDao: AppDao
) : DataRepository {

    override suspend fun getWeatherByCityName(cityName: String?) =
        apiService.getWeatherByCityName(cityName).mapDtoToModel()

    override suspend fun saveFavoriteCity(favoriteCity: FavoriteCity?) =
        appDao.saveFavoriteCity(favoriteCity.mapModelToEntity())

    override suspend fun getAllFavoriteCities() =
        appDao.getAllFavoriteCities().mapListEntityToListModel()

    override suspend fun deleteFavoriteCity(id: Int?) =
        appDao.deleteFavoriteCity(id)
}