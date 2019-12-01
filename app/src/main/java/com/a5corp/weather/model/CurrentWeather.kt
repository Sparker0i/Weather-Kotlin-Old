package com.a5corp.weather.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Clouds(
    val all: Int
)

@JsonClass(generateAdapter = true)
data class CurrentWeather(
    @Json(name = "clouds") val clouds: Clouds,
    @Json(name = "cod") val status: Int,
    @Json(name = "coord") val coordinates: Coordinates,
    @Json(name = "dt") val timestamp: Int,
    @Json(name = "id") val id: Int,
    @Json(name = "main") val weather: Weather,
    @Json(name = "name") val name: String,
    @Json(name = "sys") val sys: Sys,
    @Json(name = "visibility") val visibility: Int,
    @Json(name = "weather") val condition: List<Condition>,
    @Json(name = "wind") val wind: Wind
)

@JsonClass(generateAdapter = true)
data class Coordinates(
    @Json(name = "lat") val lat: Double,
    @Json(name = "lon") val lon: Double
)

@JsonClass(generateAdapter = true)
data class Weather(
    @Json(name = "humidity") val humidity: Int,
    @Json(name = "pressure") val pressure: Int,
    @Json(name = "temp") val temperature: Double,
    @Json(name = "temp_max") val maxTemperature: Double,
    @Json(name = "temp_min") val minTemperature: Int
)

@JsonClass(generateAdapter = true)
data class Sys(
    @Json(name = "country") val country: String,
    @Json(name = "id") val id: Int,
    @Json(name = "sunrise") val sunrise: Long,
    @Json(name = "sunset") val sunset: Int,
    @Json(name = "type") val type: Int
)

@JsonClass(generateAdapter = true)
data class Condition(
    @Json(name = "description") val description: String,
    @Json(name = "id") val id: Int
)

@JsonClass(generateAdapter = true)
data class Wind(
    @Json(name = "deg") val degree: Int,
    @Json(name = "speed") val speed: Double
)