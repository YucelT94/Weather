package com.yucelt.data.mapper

import com.yucelt.data.model.dto.CloudsDto
import com.yucelt.data.model.entity.CloudsEntity

fun CloudsDto?.mapDtoToEntity() = CloudsEntity(all = this?.all)
