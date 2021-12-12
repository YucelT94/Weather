package com.yucelt.data.mapper

import com.yucelt.data.dto.WeatherDto
import com.yucelt.domain.model.Weather


fun List<WeatherDto>?.mapListDtoToListModel() = this?.map { it.mapDtoToModel() }

fun WeatherDto?.mapDtoToModel() = Weather(
    id = this?.id,
    main = this?.main,
    description = this?.description,
    icon = this?.icon
)
