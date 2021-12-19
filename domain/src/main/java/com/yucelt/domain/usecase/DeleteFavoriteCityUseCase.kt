package com.yucelt.domain.usecase

import com.yucelt.base.domain.usecase.BaseUseCase
import com.yucelt.domain.repository.DataRepository
import javax.inject.Inject

class DeleteFavoriteCityUseCase @Inject constructor(
    private val dataRepository: DataRepository
) : BaseUseCase<Int?, Int>() {

    override suspend fun execute(params: Int?) = dataRepository.deleteFavoriteCity(params)
}
