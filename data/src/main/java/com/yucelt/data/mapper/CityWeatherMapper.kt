package com.yucelt.data.mapper

import com.yucelt.common.extensions.toPrettyDate
import com.yucelt.data.model.dto.CityWeatherDto
import com.yucelt.data.model.entity.CityWeatherEntity
import com.yucelt.domain.model.CityWeather

fun CityWeatherDto?.mapDtoToModel() = CityWeather(
    weather = this?.weather?.mapListDtoToListModel(),
    main = this?.main?.mapDtoToModel(),
    prettyDate = this?.dt?.toPrettyDate(),
    id = this?.id,
    name = this?.name,
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
    weather = this?.weather?.mapListEntityToListModel(),
    main = this?.main?.mapEntityToModel(),
    prettyDate = this?.dt?.toPrettyDate(),
    id = this?.id,
    name = this?.name,
)
