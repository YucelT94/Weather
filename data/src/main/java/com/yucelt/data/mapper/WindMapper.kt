package com.yucelt.data.mapper

import com.yucelt.data.model.dto.WindDto
import com.yucelt.data.model.entity.WindEntity

fun WindDto?.mapDtoToEntity() = WindEntity(speed = this?.speed, deg = this?.deg)
