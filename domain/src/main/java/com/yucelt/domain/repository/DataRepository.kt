package com.yucelt.domain.repository

import com.yucelt.domain.model.CityWeather
import com.yucelt.domain.model.FavoriteCity

interface DataRepository {

    suspend fun getWeatherByCityName(cityName: String?): CityWeather

    suspend fun saveFavoriteCity(favoriteCity: FavoriteCity?): Long?

    suspend fun getAllFavoriteCities(): List<FavoriteCity>?

    suspend fun deleteFavoriteCity(id: Int?): Int?
}