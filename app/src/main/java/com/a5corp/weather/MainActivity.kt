package com.a5corp.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.a5corp.weather.service.ApiFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weatherService = ApiFactory.owmApi

        GlobalScope.launch(Dispatchers.Main) {
            val request = weatherService.getCurrentWeatherDataByName("Bengaluru", "metric")
            try {
                val response = request.await()
                if(response.isSuccessful) {
                    val weatherResponse = response.body()
                    Timber.tag("Response").d(weatherResponse.toString())
                }
                else {
                    Timber.d(response.errorBody().toString())
                }
            }
            catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
