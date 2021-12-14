package com.yucelt.data.mapper

import com.yucelt.data.model.dto.WindDto
import com.yucelt.data.model.entity.WindEntity
import com.yucelt.domain.model.Wind

fun WindDto?.mapDtoToModel() = Wind(speed = this?.speed, deg = this?.deg)

fun WindDto?.mapDtoToEntity() = WindEntity(speed = this?.speed, deg = this?.deg)

fun WindEntity?.mapEntityToModel() = Wind(speed = this?.speed, deg = this?.deg)