package com.yucelt.data.model.dto

import com.squareup.moshi.Json
import com.yucelt.base.data.dto.BaseDto

data class CityWeatherDto(
    @field:Json(name = "coord") val coord: CoordDto?,
    @field:Json(name = "weather") val weather: List<WeatherDto>?,
    @field:Json(name = "base") val base: String?,
    @field:Json(name = "main") val main: MainWeatherDto?,
    @field:Json(name = "visibility") val visibility: Int?,
    @field:Json(name = "wind") val wind: WindDto?,
    @field:Json(name = "rain") val rain: RainDto?,
    @field:Json(name = "clouds") val clouds: CloudsDto?,
    @field:Json(name = "dt") val dt: Int?,
    @field:Json(name = "sys") val sys: SysDto?,
    @field:Json(name = "timezone") val timezone: Int?,
    @field:Json(name = "id") val id: Int?,
    @field:Json(name = "name") val name: String?,
    @field:Json(name = "cod") val cod: Int?
) : BaseDto

data class CoordDto(
    @field:Json(name = "lon") val lon: Double?,
    @field:Json(name = "lat") val lat: Double?
) : BaseDto

data class WeatherDto(
    @field:Json(name = "id") val id: Int?,
    @field:Json(name = "main") val main: String?,
    @field:Json(name = "description") val description: String?,
    @field:Json(name = "icon") val icon: String?
) : BaseDto

data class MainWeatherDto(
    @field:Json(name = "temp") val temp: Double?,
    @field:Json(name = "feels_like") val feelsLike: Double?,
    @field:Json(name = "temp_min") val tempMin: Double?,
    @field:Json(name = "temp_max") val tempMax: Double?,
    @field:Json(name = "pressure") val pressure: Int?,
    @field:Json(name = "humidity") val humidity: Int?
) : BaseDto

data class WindDto(
    @field:Json(name = "speed") val speed: Double?,
    @field:Json(name = "deg") val deg: Int?
) : BaseDto

data class RainDto(
    @field:Json(name = "1h") val oneHour: Double?
) : BaseDto

data class CloudsDto(
    @field:Json(name = "all") val all: Int?
) : BaseDto

data class SysDto(
    @field:Json(name = "type") val type: Int?,
    @field:Json(name = "id") val id: Int?,
    @field:Json(name = "country") val country: String?,
    @field:Json(name = "sunrise") val sunrise: Int?,
    @field:Json(name = "sunset") val sunset: Int?
) : BaseDto