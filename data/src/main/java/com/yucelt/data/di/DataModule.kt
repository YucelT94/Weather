package com.yucelt.data.di

import android.content.Context
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.yucelt.common.util.Constant
import com.yucelt.data.BuildConfig
import com.yucelt.data.datasource.ApiDataRepository
import com.yucelt.data.interceptor.TokenInterceptor
import com.yucelt.data.remote.ApiService
import com.yucelt.domain.repository.ApiRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    @Singleton
    fun provideMoshi(): Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    @Provides
    @Singleton
    fun providesOkHttpClient(
        context: Context,
        tokenInterceptor: TokenInterceptor
    ): OkHttpClient {
        val cacheSize = (5 * 1024 * 1024).toLong()
        val mCache = Cache(context.cacheDir, cacheSize)

        val interceptor = HttpLoggingInterceptor().apply {
            level =
                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        }

        val client = OkHttpClient.Builder()
            .cache(mCache)
            .connectTimeout(Constant.CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(Constant.WRITE_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(Constant.READ_TIMEOUT, TimeUnit.SECONDS)
            .addNetworkInterceptor(interceptor)
            .addInterceptor(tokenInterceptor)

        return client.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        moshi: Moshi,
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    @Singleton
    fun provideApiServices(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)
}