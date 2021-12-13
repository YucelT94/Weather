package com.yucelt.data.repository

import com.yucelt.data.mapper.mapDtoToModel
import com.yucelt.data.remote.ApiService
import com.yucelt.domain.model.CityWeather
import com.yucelt.domain.repository.DataRepository
import javax.inject.Inject

class DataRepositoryImpl @Inject constructor(private val apiService: ApiService) : DataRepository {

    override suspend fun getWeatherByCityName(cityName: String?): CityWeather {
        return apiService.getWeatherByCityName(cityName).mapDtoToModel()
    }
}