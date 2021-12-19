package com.yucelt.domain.usecase

import com.yucelt.base.domain.usecase.BaseUseCase
import com.yucelt.domain.model.CityWeather
import com.yucelt.domain.repository.DataRepository
import javax.inject.Inject

class GetWeatherByCityNameUseCase @Inject constructor(
    private val dataRepository: DataRepository
) : BaseUseCase<CityWeather, String>() {

    override suspend fun execute(params: String?) = dataRepository.getWeatherByCityName(params)
}