package com.yucelt.data.mapper

import com.yucelt.data.model.dto.WeatherDto
import com.yucelt.data.model.entity.WeatherEntity
import com.yucelt.domain.model.Weather

fun List<WeatherDto>?.mapListDtoToListModel() = this?.map { it.mapDtoToModel() }

fun WeatherDto?.mapDtoToModel() = Weather(
    id = this?.id,
    main = this?.main,
    description = this?.description,
    icon = this?.icon
)

fun List<WeatherDto>?.mapListDtoToListEntity() = this?.map { it.mapDtoToEntity() }

fun WeatherDto?.mapDtoToEntity() = WeatherEntity(
    id = this?.id,
    main = this?.main,
    description = this?.description,
    icon = this?.icon
)

fun List<WeatherEntity>?.mapListEntityToListModel() = this?.map { it.mapEntityToModel() }

fun WeatherEntity?.mapEntityToModel() = Weather(
    id = this?.id,
    main = this?.main,
    description = this?.description,
    icon = this?.icon
)
