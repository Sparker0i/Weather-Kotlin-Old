package com.a5corp.weather.application

import android.app.Application
import com.a5corp.weather.BuildConfig
import timber.log.Timber

class SimpleWeather : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}

