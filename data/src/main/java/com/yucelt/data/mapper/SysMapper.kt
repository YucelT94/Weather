package com.yucelt.data.mapper

import com.yucelt.data.model.dto.SysDto
import com.yucelt.data.model.entity.SysEntity
import com.yucelt.domain.model.Sys

fun SysDto?.mapDtoToModel() = Sys(
    type = this?.type,
    id = this?.id,
    country = this?.country,
    sunrise = this?.sunrise,
    sunset = this?.sunset
)

fun SysDto?.mapDtoToEntity() = SysEntity(
    type = this?.type,
    id = this?.id,
    country = this?.country,
    sunrise = this?.sunrise,
    sunset = this?.sunset
)

fun SysEntity?.mapEntityToModel() = Sys(
    type = this?.type,
    id = this?.id,
    country = this?.country,
    sunrise = this?.sunrise,
    sunset = this?.sunset
)

fun Sys?.mapModelToEntity() = SysEntity(
    type = this?.type,
    id = this?.id,
    country = this?.country,
    sunrise = this?.sunrise,
    sunset = this?.sunset
)
