package com.yucelt.data.mapper

import com.yucelt.data.model.dto.MainWeatherDto
import com.yucelt.data.model.entity.MainWeatherEntity
import com.yucelt.domain.model.MainWeather

fun MainWeatherDto?.mapDtoToModel() = MainWeather(
    temp = this?.temp,
    feelsLike = this?.feelsLike,
    tempMin = this?.tempMin,
    tempMax = this?.tempMax,
    pressure = this?.pressure,
    humidity = this?.humidity
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
    temp = this?.temp,
    feelsLike = this?.feelsLike,
    tempMin = this?.tempMin,
    tempMax = this?.tempMax,
    pressure = this?.pressure,
    humidity = this?.humidity
)