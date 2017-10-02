package com.awtia.weather.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.awtia.weather.R
import com.awtia.weather.domain.model.Forecast
import com.awtia.weather.domain.model.ForecastList
import com.awtia.weather.ui.utils.ctx
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_forecast.view.*

/**
 * Created by csaba.dobai on 01-10-17.
 */

class ForecastListAdapter(private val weekForecast: ForecastList, private val itemClick: (Forecast) -> Unit) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(weekForecast[position])
    }

    override fun getItemCount() = weekForecast.size()

    class ViewHolder(view: View, private val itemClick: (Forecast) -> Unit) : RecyclerView.ViewHolder(view) {
        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.with(itemView.ctx).load(iconUrl).into(itemView.iconView)
                itemView.dateView.text = date
                itemView.descriptionView.text = description
                itemView.maxTemperatureView.text = "${high}º"
                itemView.minTemperatureView.text = "${low}º"
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }

    interface OnItemClickListener {
        operator fun invoke(forecast: Forecast)
    }
}