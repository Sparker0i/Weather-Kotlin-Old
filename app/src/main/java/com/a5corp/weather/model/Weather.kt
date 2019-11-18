package com.a5corp.weather.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CurrentWeather(
    @Json(name = "coord") val coordinates: Coordinates,
    @Json(name = "weather") val condition: List<Condition>,
    @Json(name = "base") val base: String,
    @Json(name = "main") val weatherCondition: Weather,
    @Json(name = "wind") val windCondition: Wind,
    @Json(name = "clouds") val cloudCondition: Cloud,
    @Json(name = "rain") val rainCondition: Rain,
    @Json(name = "snow") val snowCondition: Snow,
    @Json(name = "dt") val date: Double,
    @Json(name = "sys") val sysCondition: Sys,
    @Json(name = "id") val cityId: Long,
    @Json(name = "name") val cityName: String,
    @Json(name = "cod") val status: Int
)

@JsonClass(generateAdapter = true)
data class Coordinates(
    @Json(name = "lat") val latitude: String,
    @Json(name = "lon") val longitude: String
)
@JsonClass(generateAdapter = true)
data class Condition(
    @Json(name = "id") val id: Int,
    @Json(name = "description") val description: String
)

@JsonClass(generateAdapter = true)
data class Weather(
    @Json(name = "temp") val temperature: Double,
    @Json(name = "pressure") val pressure: Double,
    @Json(name = "humidity") val humidity: Double,
    @Json(name = "temp_min") val minimumTemperature: Double,
    @Json(name = "temp_max") val maximumTemperature: Double
)

@JsonClass(generateAdapter = true)
data class Wind(
    @Json(name = "speed") val speed: Double,
    @Json(name = "deg") val degree: Double
)

@JsonClass(generateAdapter = true)
data class Cloud(@Json(name = "all") val cloudiness: Double)

@JsonClass(generateAdapter = true)
data class Rain(
    @Json(name = "1h") val oneHour: Double,
    @Json(name = "3h") val threeHour: Double
)

@JsonClass(generateAdapter = true)
data class Snow(
    @Json(name = "1h") val oneHour: Double,
    @Json(name = "3h") val threeHour: Double
)

@JsonClass(generateAdapter = true)
data class Sys(
    @Json(name = "message") val message: Double,
    @Json(name = "country") val country: String,
    @Json(name = "sunrise") val sunrise: Long,
    @Json(name = "sunset") val sunset: Long
)