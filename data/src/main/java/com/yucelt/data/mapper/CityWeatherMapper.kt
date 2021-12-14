package com.yucelt.data.mapper

import com.yucelt.data.model.dto.CityWeatherDto
import com.yucelt.data.model.entity.CityWeatherEntity
import com.yucelt.domain.model.CityWeather

fun CityWeatherDto?.mapDtoToModel() = CityWeather(
    coord = this?.coord?.mapDtoToModel(),
    weather = this?.weather?.mapListDtoToListModel(),
    base = this?.base,
    main = this?.main?.mapDtoToModel(),
    visibility = this?.visibility,
    wind = this?.wind?.mapDtoToModel(),
    rain = this?.rain?.mapDtoToModel(),
    clouds = this?.clouds?.mapDtoToModel(),
    dt = this?.dt,
    sys = this?.sys?.mapDtoToModel(),
    timezone = this?.timezone,
    id = this?.id,
    name = this?.name,
    cod = this?.cod
)

fun CityWeatherDto?.mapDtoToEntity() = CityWeatherEntity(
    coord = this?.coord?.mapDtoToEntity(),
    weather = this?.weather?.mapListDtoToListEntity(),
    base = this?.base,
    main = this?.main?.mapDtoToEntity(),
    visibility = this?.visibility,
    wind = this?.wind?.mapDtoToEntity(),
    rain = this?.rain?.mapDtoToEntity(),
    clouds = this?.clouds?.mapDtoToEntity(),
    dt = this?.dt,
    sys = this?.sys?.mapDtoToEntity(),
    timezone = this?.timezone,
    id = this?.id,
    name = this?.name,
    cod = this?.cod
)

fun CityWeatherEntity?.mapEntityToModel() = CityWeather(
    coord = this?.coord?.mapEntityToModel(),
    weather = this?.weather?.mapListEntityToListModel(),
    base = this?.base,
    main = this?.main?.mapEntityToModel(),
    visibility = this?.visibility,
    wind = this?.wind?.mapEntityToModel(),
    rain = this?.rain?.mapEntityToModel(),
    clouds = this?.clouds?.mapEntityToModel(),
    dt = this?.dt,
    sys = this?.sys?.mapEntityToModel(),
    timezone = this?.timezone,
    id = this?.id,
    name = this?.name,
    cod = this?.cod
)
