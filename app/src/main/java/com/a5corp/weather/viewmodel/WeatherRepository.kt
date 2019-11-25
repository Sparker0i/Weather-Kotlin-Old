package com.a5corp.weather.viewmodel

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*
import com.a5corp.weather.model.CurrentWeather
import com.a5corp.weather.model.DailyWeather
import com.a5corp.weather.service.ApiFactory
import retrofit2.HttpException
import java.lang.Exception

class WeatherRepository() {
    private var currentWeather = MutableLiveData<CurrentWeather>()
    private var dailyWeather = MutableLiveData<DailyWeather>()

    val completableJob = Job()

    private val coroutineScope = CoroutineScope(Dispatchers.IO + completableJob)

    private val apiCoroutineService by lazy {
        ApiFactory.getService()
    }

    fun getCurrentWeather(): MutableLiveData<CurrentWeather> {
        coroutineScope.launch {
            val request = apiCoroutineService.getCurrentWeatherDataByName("Bengaluru", "metric")

            withContext(Dispatchers.Main) {
                try {
                    val response = request.await()

                    if (response.name != "") {
                        currentWeather.value = response
                    }
                }
                catch (e: HttpException) {
                    e.printStackTrace()
                }
                catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
        return currentWeather
    }

    fun getDailyWeather(): MutableLiveData<DailyWeather> {
        coroutineScope.launch {
            val request = apiCoroutineService.getDailyDataByName("Bengaluru", "metric", 10)

            withContext(Dispatchers.Main) {
                try {
                    val response = request.await()

                    if (response.city.name != "") {
                        dailyWeather.value = response
                    }
                }
                catch (e: HttpException) {
                    e.printStackTrace()
                }
                catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
        return dailyWeather
    }
}