package com.a5corp.weather.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DailyWeather(
    @Json(name = "city") val city : City,
    @Json(name = "cod") val cod : Int,
    @Json(name = "message") val message : Double,
    @Json(name = "cnt") val cnt : Int,
    @Json(name = "list") val list : List<Details>
)

@JsonClass(generateAdapter = true)
data class City (
    @Json(name = "id") val id : Int,
    @Json(name = "name") val name : String,
    @Json(name = "coord") val coord : Coord,
    @Json(name = "country") val country : String,
    @Json(name = "population") val population : Int,
    @Json(name = "timezone") val timezone : Int
)

@JsonClass(generateAdapter = true)
data class Coord (
    @Json(name = "lon") val lon : Double,
    @Json(name = "lat") val lat : Double
)

@JsonClass(generateAdapter = true)
data class Details (
    @Json(name = "dt") val dt : Int,
    @Json(name = "sunrise") val sunrise : Int,
    @Json(name = "sunset") val sunset : Int,
    @Json(name = "temp") val temp : Temp,
    @Json(name = "pressure") val pressure : Int,
    @Json(name = "humidity") val humidity : Int,
    @Json(name = "weather") val description: List<Description>,
    @Json(name = "speed") val speed : Double,
    @Json(name = "deg") val deg : Int,
    @Json(name = "clouds") val clouds : Int
)

@JsonClass(generateAdapter = true)
data class Temp (
    @Json(name = "day") val day : Double,
    @Json(name = "min") val min : Double,
    @Json(name = "max") val max : Double,
    @Json(name = "night") val night : Double,
    @Json(name = "eve") val eve : Double,
    @Json(name = "morn") val morn : Double
)

@JsonClass(generateAdapter = true)
data class Description (
    @Json(name = "id") val id : Int,
    @Json(name = "main") val main : String,
    @Json(name = "description") val description : String,
    @Json(name = "icon") val icon : String
)