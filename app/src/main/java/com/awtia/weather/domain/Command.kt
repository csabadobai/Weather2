package com.awtia.weather.domain

import com.awtia.weather.ForecastRequest

/**
 * Created by csaba.dobai on 02-10-17.
 */
interface Command<T> {
    fun execute(): T

    class RequestForecastCommand(val zipCode: String) : Command<ForecastList> {
        override fun execute(): ForecastList {
            val forecastRequest = ForecastRequest(zipCode)
            return ForecastDataMapper().convertFromDataModel(
                    6 forecastRequest . execute ())
        }
    }
}