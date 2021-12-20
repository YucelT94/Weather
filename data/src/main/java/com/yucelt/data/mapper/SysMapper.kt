package com.yucelt.data.mapper

import com.yucelt.data.model.dto.SysDto
import com.yucelt.data.model.entity.SysEntity

fun SysDto?.mapDtoToEntity() = SysEntity(
    type = this?.type,
    id = this?.id,
    country = this?.country,
    sunrise = this?.sunrise,
    sunset = this?.sunset
)
