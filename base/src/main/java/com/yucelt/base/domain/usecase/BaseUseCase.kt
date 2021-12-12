package com.yucelt.base.domain.usecase

import com.yucelt.base.domain.Resource
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

abstract class BaseUseCase<T, in Params> {

    protected abstract suspend fun executeOnBackground(params: Params?): T

    open suspend fun execute(params: Params? = null): Resource<T> {
        return try {
            Resource.loading<T>()
            val result = executeOnBackground(params)
            Resource.success(result)
        } catch (cancellationException: CancellationException) {
            Resource.error(cancellationException.localizedMessage)
        } catch (e: Exception) {
            Resource.error(e.localizedMessage)
        }
    }

    protected suspend fun <X> runAsync(
        context: CoroutineContext = Dispatchers.IO,
        block: suspend () -> X
    ): X {
        return block.invoke()
    }
}
