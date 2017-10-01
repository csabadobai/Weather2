package com.awtia.weather.domain

import com.awtia.weather.data.Forecast
import com.awtia.weather.data.ForecastResult
import java.text.DateFormat
import java.util.*
import com.antonioleiva.weatherapp.domain.model.Forecast as ModelForecast

/**
 * Created by csaba.dobai on 02-10-17.
 */
class ForecastDataMapper {
    fun convertFromDataModel(forecast: ForecastResult): ForecastList {
        return ForecastList(forecast.city.name, forecast.city.country), convertForecastListToDomain(forecast.list)
    }

    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list.map { convertForecastItemToDomain(it) }
    }

    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
        return ModelForecast(convertDate(forecast.dt), forecast.weather[0].description, forecast.temp.max.toInt(), forecast.temp.min.toInt())
    }

    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date * 1000)
    }
}