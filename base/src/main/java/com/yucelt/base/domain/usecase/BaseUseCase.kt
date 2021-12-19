package com.yucelt.base.domain.usecase

import com.yucelt.base.domain.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch

abstract class BaseUseCase<T, in Params> {
    suspend operator fun invoke(params: Params? = null): Flow<Resource<T>> = execute(params)
        .catch { e ->
            emit(Resource.error((e.message)))
        }

    protected abstract suspend fun execute(params: Params? = null): Flow<Resource<T>>
}