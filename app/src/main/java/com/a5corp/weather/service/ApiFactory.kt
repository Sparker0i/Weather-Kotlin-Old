package com.a5corp.weather.service

import com.a5corp.weather.BuildConfig
import com.a5corp.weather.utils.AppConstants
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiFactory {
    @Volatile private var owmApi: OwmApi? = null

    private val authInterceptor = Interceptor {chain ->
        val newUrl = chain.request().url
            .newBuilder()
            .addQueryParameter(AppConstants.API_KEY_PARAM , AppConstants.OWM_API_KEY)
            .addQueryParameter(AppConstants.FORMAT_PARAM , AppConstants.FORMAT_VALUE)
            .build()

        val newRequest = chain.request()
            .newBuilder()
            .url(newUrl)
            .build()

        chain.proceed(newRequest)
    }

    private val loggingInterceptor =  HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val owmClient =
        if (BuildConfig.DEBUG) {
            OkHttpClient().newBuilder()
                .addInterceptor(authInterceptor)
                .addInterceptor(loggingInterceptor)
                .build()
        }
        else {
            OkHttpClient().newBuilder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(authInterceptor)
                .build()
        }

    private fun retrofit(url: String): Retrofit = Retrofit.Builder()
        .client(owmClient)
        .baseUrl(url)
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    fun getService(): OwmApi {
        return owmApi ?: synchronized(this) {
            val instance = retrofit(AppConstants.OWM_API_URL)
                .create(OwmApi::class.java)

            owmApi = instance
            instance
        }
    }
}