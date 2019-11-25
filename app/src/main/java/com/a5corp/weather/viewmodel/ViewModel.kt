package com.a5corp.weather.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.a5corp.weather.model.CurrentWeather
import com.a5corp.weather.model.DailyWeather

class MainViewModel(): ViewModel() {
    val weatherRepository = WeatherRepository()
    val weatherData: LiveData<CurrentWeather> get() = weatherRepository.getCurrentWeather()
    val dailyWeather: LiveData<DailyWeather> get() = weatherRepository.getDailyWeather()

    override fun onCleared() {
        super.onCleared()
        weatherRepository.completableJob.cancel()
    }
}