package com.yucelt.data.local.converter

import androidx.room.TypeConverter
import com.squareup.moshi.Moshi
import com.yucelt.data.local.converter.BaseConverter.fromEntityListToJson
import com.yucelt.data.local.converter.BaseConverter.fromEntityToJson
import com.yucelt.data.local.converter.BaseConverter.fromJsonToEntity
import com.yucelt.data.local.converter.BaseConverter.fromJsonToEntityList
import com.yucelt.data.model.entity.*

object CityWeatherConverters {

    private lateinit var moshi: Moshi

    fun initialize(moshi: Moshi) {
        this.moshi = moshi
    }

    @TypeConverter
    fun fromCloudsEntity(entity: CloudsEntity?): String? = fromEntityToJson(entity, moshi)

    @TypeConverter
    fun toCloudsEntity(json: String?): CloudsEntity? = fromJsonToEntity(json, moshi)

    @TypeConverter
    fun fromCoordEntity(entity: CoordEntity?): String? = fromEntityToJson(entity, moshi)

    @TypeConverter
    fun toCoordEntity(json: String?): CoordEntity? = fromJsonToEntity(json, moshi)

    @TypeConverter
    fun fromMainWeatherEntity(entity: MainWeatherEntity?): String? = fromEntityToJson(entity, moshi)

    @TypeConverter
    fun toMainWeatherEntity(json: String?): MainWeatherEntity? = fromJsonToEntity(json, moshi)

    @TypeConverter
    fun fromRainEntity(entity: RainEntity?): String? = fromEntityToJson(entity, moshi)

    @TypeConverter
    fun toRainEntity(json: String?): RainEntity? = fromJsonToEntity(json, moshi)

    @TypeConverter
    fun fromSysEntity(entity: SysEntity?): String? = fromEntityToJson(entity, moshi)

    @TypeConverter
    fun toSysEntity(json: String?): SysEntity? = fromJsonToEntity(json, moshi)

    @TypeConverter
    fun fromWindEntityList(entity: List<WeatherEntity>?): String? = fromEntityListToJson(entity, moshi)

    @TypeConverter
    fun toWindEntityList(json: String?): List<WeatherEntity>? = fromJsonToEntityList(json, moshi)

    @TypeConverter
    fun fromWeatherEntity(entity: WeatherEntity?): String? = fromEntityToJson(entity, moshi)

    @TypeConverter
    fun toWeatherEntity(json: String?): WeatherEntity? = fromJsonToEntity(json, moshi)

    @TypeConverter
    fun fromWindEntity(entity: WindEntity?): String? = fromEntityToJson(entity, moshi)

    @TypeConverter
    fun toWindEntity(json: String?): WindEntity? = fromJsonToEntity(json, moshi)
}