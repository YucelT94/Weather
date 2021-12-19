package com.yucelt.domain.repository

import com.yucelt.base.domain.Resource
import com.yucelt.domain.model.CityWeather
import com.yucelt.domain.model.FavoriteCity
import kotlinx.coroutines.flow.Flow

interface DataRepository {

    suspend fun getWeatherByCityName(cityName: String?): Flow<Resource<CityWeather>>

    suspend fun saveFavoriteCity(favoriteCity: FavoriteCity?): Flow<Resource<Long?>>

    suspend fun getAllFavoriteCities(): Flow<Resource<List<FavoriteCity>?>>

    suspend fun deleteFavoriteCity(id: Int?): Flow<Resource<Int?>>
}