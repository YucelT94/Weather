package com.yucelt.data.datasource

import com.yucelt.data.mapper.mapDtoToModel
import com.yucelt.data.remote.ApiService
import com.yucelt.domain.model.CityWeather
import com.yucelt.domain.repository.ApiRepository
import javax.inject.Inject

class ApiDataRepository @Inject constructor(private val apiService: ApiService) : ApiRepository {

    override suspend fun getWeatherByCityName(cityName: String?): CityWeather {
        return apiService.getWeatherByCityName(cityName).mapDtoToModel()
    }
}