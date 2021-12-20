package com.yucelt.data.mapper

import com.yucelt.data.model.dto.CoordDto
import com.yucelt.data.model.entity.CoordEntity

fun CoordDto?.mapDtoToEntity() = CoordEntity(
    lon = this?.lon,
    lat = this?.lat
)
