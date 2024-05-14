package com.scriptintech.unitconverterx.repository.temperature

import com.scriptintech.unitconverterx.components.model.UDropdownModel

interface Temperature {
    fun calculate(keyFrom: String, keyTo: String, value: Double): Double
    fun celsiusToFahrenheit(celsius: Double): Double

    fun celsiusToKelvin(celsius: Double): Double

    fun fahrenheitToCelsius(fahrenheit: Double): Double

    fun fahrenheitToKelvin(fahrenheit: Double): Double

    fun kelvinToCelsius(kelvin: Double): Double

    fun kelvinToFahrenheit(kelvin: Double): Double

}