package com.yucelt.data.model.dto

import com.squareup.moshi.Json
import com.yucelt.base.data.dto.BaseDto

data class CityWeatherDto(
    @Json(name = "coord") val coord: CoordDto?,
    @Json(name = "weather") val weather: List<WeatherDto>?,
    @Json(name = "base") val base: String?,
    @Json(name = "main") val main: MainWeatherDto?,
    @Json(name = "visibility") val visibility: Int?,
    @Json(name = "wind") val wind: WindDto?,
    @Json(name = "rain") val rain: RainDto?,
    @Json(name = "clouds") val clouds: CloudsDto?,
    @Json(name = "dt") val dt: Int?,
    @Json(name = "sys") val sys: SysDto?,
    @Json(name = "timezone") val timezone: Int?,
    @Json(name = "id") val id: Int?,
    @Json(name = "name") val name: String?,
    @Json(name = "cod") val cod: Int?
) : BaseDto

data class CoordDto(
    @Json(name = "lon") val lon: Double?,
    @Json(name = "lat") val lat: Double?
) : BaseDto

data class WeatherDto(
    @Json(name = "id") val id: Int?,
    @Json(name = "main") val main: String?,
    @Json(name = "description") val description: String?,
    @Json(name = "icon") val icon: String?
) : BaseDto

data class MainWeatherDto(
    @Json(name = "temp") val temp: Double?,
    @Json(name = "feels_like") val feelsLike: Double?,
    @Json(name = "temp_min") val tempMin: Double?,
    @Json(name = "temp_max") val tempMax: Double?,
    @Json(name = "pressure") val pressure: Int?,
    @Json(name = "humidity") val humidity: Int?
) : BaseDto

data class WindDto(
    @Json(name = "speed") val speed: Double?,
    @Json(name = "deg") val deg: Int?
) : BaseDto

data class RainDto(
    @Json(name = "1h") val oneHour: Double?
) : BaseDto

data class CloudsDto(
    @Json(name = "all") val all: Int?
) : BaseDto

data class SysDto(
    @Json(name = "type") val type: Int?,
    @Json(name = "id") val id: Int?,
    @Json(name = "country") val country: String?,
    @Json(name = "sunrise") val sunrise: Int?,
    @Json(name = "sunset") val sunset: Int?
) : BaseDto