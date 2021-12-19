package com.yucelt.data.mapper

import com.yucelt.data.model.dto.CoordDto
import com.yucelt.data.model.entity.CoordEntity
import com.yucelt.domain.model.Coord

fun CoordDto?.mapDtoToModel() = Coord(
    lon = this?.lon,
    lat = this?.lat
)

fun CoordDto?.mapDtoToEntity() = CoordEntity(
    lon = this?.lon,
    lat = this?.lat
)

fun CoordEntity?.mapEntityToModel() = Coord(
    lon = this?.lon,
    lat = this?.lat
)

fun Coord?.mapModelToEntity() = CoordEntity(
    lon = this?.lon,
    lat = this?.lat
)