package com.yucelt.data.mapper

import com.yucelt.data.dto.WindDto
import com.yucelt.domain.model.Wind

fun WindDto?.mapDtoToModel() = Wind(speed = this?.speed, deg = this?.deg)