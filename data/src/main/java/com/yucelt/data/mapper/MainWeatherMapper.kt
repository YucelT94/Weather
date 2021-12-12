package com.yucelt.data.mapper

import com.yucelt.data.dto.MainWeatherDto
import com.yucelt.domain.model.MainWeather

fun MainWeatherDto?.mapDtoToModel() = MainWeather(
    temp = this?.temp,
    feelsLike = this?.feelsLike,
    tempMin = this?.tempMin,
    tempMax = this?.tempMax,
    pressure = this?.pressure,
    humidity = this?.humidity
)