package com.a5corp.weather.service

import com.a5corp.weather.model.CurrentWeather
import com.a5corp.weather.model.DailyWeather
import com.a5corp.weather.utils.AppConstants
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface OwmApi {
    @GET("weather")
    fun getCurrentWeatherDataByName(@Query(AppConstants.QUERY_PARAM) city: String, @Query(AppConstants.UNITS_PARAM) units: String): Deferred<CurrentWeather>

    @GET("forecast/daily")
    fun getDailyDataByName(@Query(AppConstants.QUERY_PARAM) city: String, @Query(AppConstants.UNITS_PARAM) units: String, @Query(AppConstants.DAYS_PARAM) days: Int): Deferred<DailyWeather>

    @GET("weather")
    fun getCurrentWeatherDataByCoordinates(@Query(AppConstants.LATITUDE_PARAM) lat: String, @Query(AppConstants.LONGITUDE_PARAM) lon: String, @Query(AppConstants.UNITS_PARAM) units: String): Deferred<CurrentWeather>

    @GET("forecast/daily")
    fun getDailyDataByCoordinates(@Query(AppConstants.LATITUDE_PARAM) lat: String, @Query(AppConstants.LONGITUDE_PARAM) lon: String, @Query(AppConstants.UNITS_PARAM) units: String, @Query(AppConstants.DAYS_PARAM) days: Int): Deferred<DailyWeather>
}