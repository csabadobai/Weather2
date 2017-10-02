package com.awtia.weather.domain.commands

import com.awtia.weather.domain.mappers.ForecastDataMapper
import com.awtia.weather.domain.model.ForecastList
import com.awtia.weather.domain.model.ForecastRequest

/**
 * Created by csaba.dobai on 02-10-17.
 */
class RequestForecastCommand(val zipCode: String) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}