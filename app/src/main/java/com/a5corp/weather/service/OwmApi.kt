package com.a5corp.weather.service

import com.a5corp.weather.model.CurrentWeather
import com.a5corp.weather.model.Weather
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface OwmApi {
    @GET("weather")
    fun getCurrentWeatherDataByName(city: String, units: String): Deferred<Response<CurrentWeather>>

    @GET("weather")
    fun getCurrentWeatherDataByCoordinates(lat: String, lon: String, units: String): Deferred<Response<CurrentWeather>>
}