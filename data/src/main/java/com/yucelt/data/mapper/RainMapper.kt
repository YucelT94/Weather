package com.yucelt.data.mapper

import com.yucelt.data.model.dto.RainDto
import com.yucelt.data.model.entity.RainEntity
import com.yucelt.domain.model.Rain

fun RainDto?.mapDtoToModel() = Rain(oneHour = this?.oneHour)

fun RainDto?.mapDtoToEntity() = RainEntity(oneHour = this?.oneHour)

fun RainEntity?.mapEntityToModel() = Rain(oneHour = this?.oneHour)

fun Rain?.mapModelToEntity() = RainEntity(oneHour = this?.oneHour)