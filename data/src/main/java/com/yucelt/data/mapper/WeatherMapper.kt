package com.yucelt.data.mapper

import com.yucelt.common.extensions.capitalizeFirstLetter
import com.yucelt.data.model.dto.WeatherDto
import com.yucelt.data.model.entity.WeatherEntity
import com.yucelt.domain.model.Weather
import com.yucelt.domain.model.WeatherIcon

fun List<WeatherDto>?.mapListDtoToListModel() = this?.get(0)?.mapDtoToModel()

fun WeatherDto?.mapDtoToModel() = Weather(
    id = this?.id,
    main = this?.main,
    description = this?.description?.capitalizeFirstLetter(),
    iconResId = WeatherIcon.getIconId(this?.icon)
)

fun List<WeatherDto>?.mapListDtoToListEntity() = this?.map { it.mapDtoToEntity() }

fun WeatherDto?.mapDtoToEntity() = WeatherEntity(
    id = this?.id,
    main = this?.main,
    description = this?.description,
    icon = this?.icon
)

fun List<WeatherEntity>?.mapListEntityToListModel() = this?.get(0)?.mapEntityToModel()

fun WeatherEntity?.mapEntityToModel() = Weather(
    id = this?.id,
    main = this?.main,
    description = this?.description?.capitalizeFirstLetter(),
    iconResId = WeatherIcon.getIconId(this?.icon)
)
