package com.yucelt.data.mapper

import com.yucelt.data.model.dto.RainDto
import com.yucelt.data.model.entity.RainEntity

fun RainDto?.mapDtoToEntity() = RainEntity(oneHour = this?.oneHour)
