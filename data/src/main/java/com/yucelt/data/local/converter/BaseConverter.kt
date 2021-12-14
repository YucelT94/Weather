package com.yucelt.data.local.converter

import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

object BaseConverter {
    var moshi: Moshi = Moshi.Builder().build()

    inline fun <reified T> fromEntityToJson(value: T?): String? {
        if (value == null) {
            return (null)
        }
        val jsonAdapter = moshi.adapter(T::class.java)
        return jsonAdapter.toJson(value)
    }

    inline fun <reified T> fromJsonToEntity(value: String?): T? {
        if (value == null) {
            return (null)
        }
        val jsonAdapter = moshi.adapter(T::class.java)
        return jsonAdapter.fromJson(value)
    }

    inline fun <reified T> fromEntityListToJson(value: List<T>?): String? {
        if (value.isNullOrEmpty()) {
            return (null)
        }
        val type = Types.newParameterizedType(List::class.java, T::class.java)
        val adapter = moshi.adapter<List<T>?>(type)
        return adapter.toJson(value)
    }

    inline fun <reified T> fromJsonToEntityList(value: String?): List<T>? {
        if (value == null) {
            return listOf()
        }
        val type = Types.newParameterizedType(List::class.java, T::class.java)
        val adapter = moshi.adapter<List<T>>(type)
        return adapter.fromJson(value)
    }
}