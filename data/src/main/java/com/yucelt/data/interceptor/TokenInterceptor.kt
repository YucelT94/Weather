package com.yucelt.data.interceptor

import android.content.Context
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TokenInterceptor @Inject constructor(context: Context) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest: Request = chain.request()
        val originalHttpUrl: HttpUrl = originalRequest.url
        val url: HttpUrl = originalHttpUrl.newBuilder()
            .addQueryParameter("appid", "ea2b8fad5846f2a27f48d270819041e7")
            .addQueryParameter("lang", Locale.getDefault().language)
            .addQueryParameter("units", "metric")
            .build()

        val requestBuilder: Request.Builder = originalRequest.newBuilder()
            .url(url)

        val request = requestBuilder.build()

        return chain.proceed(request)
    }
}