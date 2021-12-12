package com.yucelt.data.mapper

import com.yucelt.data.dto.SysDto
import com.yucelt.domain.model.Sys

fun SysDto?.mapDtoToModel() = Sys(
    type = this?.type,
    id = this?.id,
    country = this?.country,
    sunrise = this?.sunrise,
    sunset = this?.sunset
)
