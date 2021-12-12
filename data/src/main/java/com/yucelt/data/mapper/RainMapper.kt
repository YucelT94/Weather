package com.yucelt.data.mapper

import com.yucelt.data.dto.RainDto
import com.yucelt.domain.model.Rain

fun RainDto?.mapDtoToModel() = Rain(oneHour = this?.oneHour)