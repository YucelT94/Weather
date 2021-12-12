package com.yucelt.data.mapper

import com.yucelt.data.dto.CoordDto
import com.yucelt.domain.model.Coord

fun CoordDto?.mapDtoToModel() = Coord(
    lon = this?.lon,
    lat = this?.lat
)