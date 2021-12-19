package com.yucelt.domain.usecase

import com.yucelt.base.domain.usecase.BaseUseCase
import com.yucelt.domain.model.FavoriteCity
import com.yucelt.domain.repository.DataRepository
import javax.inject.Inject

class SaveFavoriteCityUseCase @Inject constructor(
    private val dataRepository: DataRepository
) : BaseUseCase<Long?, FavoriteCity>() {

    override suspend fun execute(params: FavoriteCity?) = dataRepository.saveFavoriteCity(params)
}
