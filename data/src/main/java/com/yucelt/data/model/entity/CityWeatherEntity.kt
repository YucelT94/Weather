package com.yucelt.data.model.entity

import androidx.room.Entity
import com.squareup.moshi.Json
import com.yucelt.base.data.entity.BaseEntity
import com.yucelt.common.util.Constant

@Entity(tableName = Constant.FAVORITE_CITY_TABLE_NAME)
data class CityWeatherEntity(
    @field:Json(name = "coord") val coord: CoordEntity?,
    @field:Json(name = "weather") val weather: List<WeatherEntity>?,
    @field:Json(name = "base") val base: String?,
    @field:Json(name = "main") val main: MainWeatherEntity?,
    @field:Json(name = "visibility") val visibility: Int?,
    @field:Json(name = "wind") val wind: WindEntity?,
    @field:Json(name = "rain") val rain: RainEntity?,
    @field:Json(name = "clouds") val clouds: CloudsEntity?,
    @field:Json(name = "dt") val dt: Int?,
    @field:Json(name = "sys") val sys: SysEntity?,
    @field:Json(name = "timezone") val timezone: Int?,
    @field:Json(name = "id") val id: Int?,
    @field:Json(name = "name") val name: String?,
    @field:Json(name = "cod") val cod: Int?
) : BaseEntity

data class CoordEntity(
    @field:Json(name = "lon") val lon: Double?,
    @field:Json(name = "lat") val lat: Double?
) : BaseEntity

data class WeatherEntity(
    @field:Json(name = "id") val id: Int?,
    @field:Json(name = "main") val main: String?,
    @field:Json(name = "description") val description: String?,
    @field:Json(name = "icon") val icon: String?
) : BaseEntity

data class MainWeatherEntity(
    @field:Json(name = "temp") val temp: Double?,
    @field:Json(name = "feels_like") val feelsLike: Double?,
    @field:Json(name = "temp_min") val tempMin: Double?,
    @field:Json(name = "temp_max") val tempMax: Double?,
    @field:Json(name = "pressure") val pressure: Int?,
    @field:Json(name = "humidity") val humidity: Int?
) : BaseEntity

data class WindEntity(
    @field:Json(name = "speed") val speed: Double?,
    @field:Json(name = "deg") val deg: Int?
) : BaseEntity

data class RainEntity(
    @field:Json(name = "1h") val oneHour: Double?
) : BaseEntity

data class CloudsEntity(
    @field:Json(name = "all") val all: Int?
) : BaseEntity

data class SysEntity(
    @field:Json(name = "type") val type: Int?,
    @field:Json(name = "id") val id: Int?,
    @field:Json(name = "country") val country: String?,
    @field:Json(name = "sunrise") val sunrise: Int?,
    @field:Json(name = "sunset") val sunset: Int?
) : BaseEntity