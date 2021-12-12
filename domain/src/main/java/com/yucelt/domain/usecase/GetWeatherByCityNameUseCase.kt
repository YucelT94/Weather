package com.yucelt.domain.usecase

import com.yucelt.base.domain.usecase.BaseUseCase
import com.yucelt.domain.model.CityWeather
import com.yucelt.domain.repository.ApiRepository
import javax.inject.Inject

class GetWeatherByCityNameUseCase @Inject constructor(
    private val apiRepository: ApiRepository
) : BaseUseCase<CityWeather, String>() {

    override suspend fun executeOnBackground(params: String?) =
        apiRepository.getWeatherByCityName(params)
}