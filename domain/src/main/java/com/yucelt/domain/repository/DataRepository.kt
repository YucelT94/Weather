package com.yucelt.domain.repository

import com.yucelt.domain.model.CityWeather

interface DataRepository {

    suspend fun getWeatherByCityName(cityName: String?): CityWeather
}