package com.yucelt.base.domain

class Resource<out T> constructor(
    val status: ResourceState,
    val data: T? = null,
    val message: String? = null
) {
    companion object {
        fun <T> loading(): Resource<T> = Resource(ResourceState.LOADING)

        fun <T> success(data: T?): Resource<T> = Resource(ResourceState.SUCCESS, data)

        fun <T> error(message: String?): Resource<T> =
            Resource(ResourceState.ERROR, message = message)
    }
}