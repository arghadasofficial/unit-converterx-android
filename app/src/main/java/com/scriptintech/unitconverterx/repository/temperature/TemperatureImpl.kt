package com.scriptintech.unitconverterx.repository.temperature

import com.scriptintech.unitconverterx.components.model.UDropdownModel

class TemperatureImpl : Temperature {
    override fun calculate(keyFrom: String, keyTo: String, value: Double): Double {
        return if (keyFrom == "celsius" && keyTo == "fahrenheit") {
            celsiusToFahrenheit(value)
        } else if (keyFrom == "celsius" && keyTo == "kelvin") {
            celsiusToKelvin(value)
        } else if (keyFrom == "fahrenheit" && keyTo == "celsius") {
            fahrenheitToCelsius(value)
        } else if (keyFrom == "fahrenheit" && keyTo == "kelvin") {
            fahrenheitToKelvin(value)
        } else if (keyFrom == "kelvin" && keyTo == "celsius") {
            kelvinToCelsius(value)
        } else if (keyFrom == "kelvin" && keyTo == "fahrenheit") {
            kelvinToFahrenheit(value)
        } else {
            0.0
        }
    }

    override fun celsiusToFahrenheit(celsius: Double): Double {
        // (0°C × 9/5) + 32
        return (celsius * 9 / 5) + 32
    }

    override fun celsiusToKelvin(celsius: Double): Double {
        // 0°C + 273.15
        return celsius + 273.15
    }

    override fun fahrenheitToCelsius(fahrenheit: Double): Double {
        TODO("Not yet implemented")
    }

    override fun fahrenheitToKelvin(fahrenheit: Double): Double {
        TODO("Not yet implemented")
    }

    override fun kelvinToCelsius(kelvin: Double): Double {
        TODO("Not yet implemented")
    }

    override fun kelvinToFahrenheit(kelvin: Double): Double {
        TODO("Not yet implemented")
    }

    override fun convertStringToDouble(input: String): Double {
        return input.toDoubleOrNull() ?: 0.0
    }

    override fun getUnits(): List<UDropdownModel> {
        return listOf(
            UDropdownModel("celsius", "Celsius"),
            UDropdownModel("fahrenheit", "Fahrenheit"),
            UDropdownModel("kelvin", "Kelvin")
        )
    }
}