package com.yucelt.data.local.converter

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.yucelt.data.local.converter.BaseConverter.fromJsonToEntity
import com.yucelt.data.local.converter.BaseConverter.fromJsonToEntityList
import com.yucelt.data.local.converter.BaseConverter.fromEntityToJson
import com.yucelt.data.local.converter.BaseConverter.fromEntityListToJson
import com.yucelt.data.model.entity.*

@ProvidedTypeConverter
class CityWeatherConverters {

    @TypeConverter
    fun fromCloudsEntity(entity: CloudsEntity?): String? = fromEntityToJson(entity)

    @TypeConverter
    fun toCloudsEntity(json: String?): CloudsEntity? = fromJsonToEntity(json)

    @TypeConverter
    fun fromCoordEntity(entity: CoordEntity?): String? = fromEntityToJson(entity)

    @TypeConverter
    fun toCoordEntity(json: String?): CoordEntity? = fromJsonToEntity(json)

    @TypeConverter
    fun fromMainWeatherEntity(entity: MainWeatherEntity?): String? = fromEntityToJson(entity)

    @TypeConverter
    fun toMainWeatherEntity(json: String?): MainWeatherEntity? = fromJsonToEntity(json)

    @TypeConverter
    fun fromRainEntity(entity: RainEntity?): String? = fromEntityToJson(entity)

    @TypeConverter
    fun toRainEntity(json: String?): RainEntity? = fromJsonToEntity(json)

    @TypeConverter
    fun fromSysEntity(entity: SysEntity?): String? = fromEntityToJson(entity)

    @TypeConverter
    fun toSysEntity(json: String?): SysEntity? = fromJsonToEntity(json)

    @TypeConverter
    fun fromWindEntityList(entity: List<WeatherEntity>?): String? = fromEntityListToJson(entity)

    @TypeConverter
    fun toWindEntityList(json: String?): List<WeatherEntity>? = fromJsonToEntityList(json)

    @TypeConverter
    fun fromWeatherEntity(entity: WeatherEntity?): String? = fromEntityToJson(entity)

    @TypeConverter
    fun toWeatherEntity(json: String?): WeatherEntity? = fromJsonToEntity(json)

    @TypeConverter
    fun fromWindEntity(entity: WindEntity?): String? = fromEntityToJson(entity)

    @TypeConverter
    fun toWindEntity(json: String?): WindEntity? = fromJsonToEntity(json)
}