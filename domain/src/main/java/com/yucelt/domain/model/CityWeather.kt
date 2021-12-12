package com.yucelt.domain.model

import com.yucelt.base.domain.model.BaseModel

data class CityWeather(
    val coord: Coord?,
    val weather: List<Weather>?,
    val base: String?,
    val main: MainWeather?,
    val visibility: Int?,
    val wind: Wind?,
    val rain: Rain?,
    val clouds: Clouds?,
    val dt: Int?,
    val sys: Sys?,
    val timezone: Int?,
    val id: Int?,
    val name: String?,
    val cod: Int?
) : BaseModel

data class Coord(
    val lon: Double?,
    val lat: Double?
) : BaseModel

data class Weather(
    val id: Int?,
    val main: String?,
    val description: String?,
    val icon: String?
) : BaseModel

data class MainWeather(
    val temp: Double?,
    val feelsLike: Double?,
    val tempMin: Double?,
    val tempMax: Double?,
    val pressure: Int?,
    val humidity: Int?
) : BaseModel

data class Wind(
    val speed: Double?,
    val deg: Int?
) : BaseModel

data class Rain(
    val oneHour: Double?
) : BaseModel

data class Clouds(
    val all: Int?
) : BaseModel

data class Sys(
    val type: Int?,
    val id: Int?,
    val country: String?,
    val sunrise: Int?,
    val sunset: Int?
) : BaseModel