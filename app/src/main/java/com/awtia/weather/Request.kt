package com.awtia.weather

import com.awtia.weather.data.ForecastResult
import com.google.gson.Gson

/**
 * Created by csaba.dobai on 01-10-17.
 */
class ForecastRequest(val zipCode: String) {

//    fun run() {
//        val forecastJsonStr = URL(url).readText()
//        Log.d(javaClass.simpleName, forecastJsonStr)
//    }

    companion object {
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val URL = "http://api.openweathermap.org/data/2.5/" + "forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "$URL&$APP_ID=$APP_ID&q="
    }

    fun execute(): ForecastResult {
        val forecastJsonStr = URL(COMPLETE_URL + zipCode).readText()
        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
    }
}