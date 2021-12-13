package com.yucelt.data.remote

import com.yucelt.data.model.dto.CityWeatherDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("weather")
    suspend fun getWeatherByCityName(@Query("q") cityName: String?): CityWeatherDto?
}