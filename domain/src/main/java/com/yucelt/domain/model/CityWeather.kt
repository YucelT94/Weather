package com.yucelt.domain.model

import com.yucelt.base.domain.model.BaseModel

data class CityWeather(
    val weather: Weather?,
    val main: MainWeather?,
    val prettyDate: String?,
    val id: Int?,
    val name: String?,
) : BaseModel

data class Weather(
    val id: Int?,
    val main: String?,
    val description: String?,
) : BaseModel

data class MainWeather(
    val prettyTemp: String?,
    val prettyFeelsLike: String?,
    val prettyTempMin: String?,
    val prettyTempMax: String?
) : BaseModel