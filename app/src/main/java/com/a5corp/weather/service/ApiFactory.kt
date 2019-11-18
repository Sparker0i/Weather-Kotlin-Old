package com.a5corp.weather.service

import com.a5corp.weather.utils.AppConstants

object ApiFactory {
    val owmApi: OwmApi = RetrofitFactory.retrofit(AppConstants.OWM_API_URL)
        .create(OwmApi::class.java)
}