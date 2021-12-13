package com.yucelt.domain.usecase

import com.yucelt.base.domain.usecase.BaseUseCase
import com.yucelt.domain.model.FavoriteCity
import com.yucelt.domain.repository.DataRepository
import javax.inject.Inject

class GetAllFavoriteCitiesUseCase @Inject constructor(
    private val dataRepository: DataRepository
) : BaseUseCase<List<FavoriteCity>?, Any>() {

    override suspend fun executeOnBackground(params: Any?) = dataRepository.getAllFavoriteCities()
}
