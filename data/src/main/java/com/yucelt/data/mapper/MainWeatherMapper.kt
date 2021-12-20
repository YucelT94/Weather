package com.yucelt.data.mapper

import com.yucelt.data.model.dto.MainWeatherDto
import com.yucelt.data.model.entity.MainWeatherEntity
import com.yucelt.domain.model.MainWeather
import kotlin.math.roundToInt

fun MainWeatherDto?.mapDtoToModel() = MainWeather(
    prettyTemp = this?.temp?.let { "${it.roundToInt()}°C" } ?: "",
    prettyFeelsLike = this?.feelsLike?.let { "${it.roundToInt()}°C" } ?: "",
    prettyTempMin = this?.tempMin?.let { "${it.roundToInt()}°C" } ?: "",
    prettyTempMax = this?.tempMax?.let { "${it.roundToInt()}°C" } ?: "",
)

fun MainWeatherDto?.mapDtoToEntity() = MainWeatherEntity(
    temp = this?.temp,
    feelsLike = this?.feelsLike,
    tempMin = this?.tempMin,
    tempMax = this?.tempMax,
    pressure = this?.pressure,
    humidity = this?.humidity
)

fun MainWeatherEntity?.mapEntityToModel() = MainWeather(
    prettyTemp = this?.temp?.let { "${it.roundToInt()}°C" } ?: "",
    prettyFeelsLike = this?.feelsLike?.let { "${it.roundToInt()}°C" } ?: "",
    prettyTempMin = this?.tempMin?.let { "${it.roundToInt()}°C" } ?: "",
    prettyTempMax = this?.tempMax?.let { "${it.roundToInt()}°C" } ?: "",
)
