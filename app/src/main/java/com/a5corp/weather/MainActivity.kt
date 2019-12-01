package com.a5corp.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.a5corp.weather.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    var mainViewModel: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        mainViewModel!!.weatherData.observe(this, Observer { weather ->
            println(weather)
        })

        mainViewModel!!.dailyWeather.observe(this, Observer { weather ->
            println(weather)
        })
    }
}
