package com.yucelt.data.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.yucelt.base.data.entity.BaseEntity
import com.yucelt.common.util.Constant

@Entity(tableName = Constant.CITY_WEATHER_TABLE_NAME)
data class CityWeatherEntity(
    @ColumnInfo(name = "coord") val coord: CoordEntity?,
    @ColumnInfo(name = "weather") val weather: List<WeatherEntity>?,
    @ColumnInfo(name = "base") val base: String?,
    @ColumnInfo(name = "main") val main: MainWeatherEntity?,
    @ColumnInfo(name = "visibility") val visibility: Int?,
    @ColumnInfo(name = "wind") val wind: WindEntity?,
    @ColumnInfo(name = "rain") val rain: RainEntity?,
    @ColumnInfo(name = "clouds") val clouds: CloudsEntity?,
    @ColumnInfo(name = "dt") val dt: Int?,
    @ColumnInfo(name = "sys") val sys: SysEntity?,
    @ColumnInfo(name = "timezone") val timezone: Int?,
    @PrimaryKey(autoGenerate = false) @ColumnInfo(name = "id") val id: Int?,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "cod") val cod: Int?
) : BaseEntity

data class CoordEntity(
    @ColumnInfo(name = "lon") val lon: Double?,
    @ColumnInfo(name = "lat") val lat: Double?
) : BaseEntity

data class WeatherEntity(
    @ColumnInfo(name = "id") val id: Int?,
    @ColumnInfo(name = "main") val main: String?,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "icon") val icon: String?
) : BaseEntity

data class MainWeatherEntity(
    @ColumnInfo(name = "temp") val temp: Double?,
    @ColumnInfo(name = "feels_like") val feelsLike: Double?,
    @ColumnInfo(name = "temp_min") val tempMin: Double?,
    @ColumnInfo(name = "temp_max") val tempMax: Double?,
    @ColumnInfo(name = "pressure") val pressure: Int?,
    @ColumnInfo(name = "humidity") val humidity: Int?
) : BaseEntity

data class WindEntity(
    @ColumnInfo(name = "speed") val speed: Double?,
    @ColumnInfo(name = "deg") val deg: Int?
) : BaseEntity

data class RainEntity(
    @ColumnInfo(name = "1h") val oneHour: Double?
) : BaseEntity

data class CloudsEntity(
    @ColumnInfo(name = "all") val all: Int?
) : BaseEntity

data class SysEntity(
    @ColumnInfo(name = "type") val type: Int?,
    @ColumnInfo(name = "id") val id: Int?,
    @ColumnInfo(name = "country") val country: String?,
    @ColumnInfo(name = "sunrise") val sunrise: Int?,
    @ColumnInfo(name = "sunset") val sunset: Int?
) : BaseEntity