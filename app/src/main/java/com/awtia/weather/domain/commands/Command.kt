package com.awtia.weather.domain.commands

/**
 * Created by csaba.dobai on 02-10-17.
 */
interface Command<T> {
    fun execute(): T
}