package com.a5corp.weather.service

import com.a5corp.weather.model.CurrentWeather
import com.a5corp.weather.utils.AppConstants
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface OwmApi {
    @GET("weather")
    fun getCurrentWeatherDataByName(@Query(AppConstants.QUERY_PARAM) city: String, @Query(AppConstants.UNITS_PARAM) units: String): Deferred<Response<CurrentWeather>>

    @GET("weather")
    fun getCurrentWeatherDataByCoordinates(lat: String, lon: String, units: String): Deferred<Response<CurrentWeather>>
}