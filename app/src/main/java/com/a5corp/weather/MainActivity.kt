package com.a5corp.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.a5corp.weather.service.ApiFactory
import com.a5corp.weather.utils.AppConstants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    val TAG = MainActivity::class.simpleName

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
                     println(weatherResponse)
                }
                else {
                    Log.d(TAG, response.errorBody().toString())
                }
            }
            catch (e: Exception) {

            }
        }
    }
}
