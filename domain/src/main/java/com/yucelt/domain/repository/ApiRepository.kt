package com.yucelt.domain.repository

import com.yucelt.domain.model.CityWeather

interface ApiRepository {

    suspend fun getWeatherByCityName(cityName: String?): CityWeather
}