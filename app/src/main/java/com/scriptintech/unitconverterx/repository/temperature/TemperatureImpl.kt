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
        // (0°F − 32) × 5/9
        return (fahrenheit - 32) * 5 / 9
    }

    override fun fahrenheitToKelvin(fahrenheit: Double): Double {
        // (0°F − 32) × 5/9 + 273.15
        return (fahrenheit - 32) * 5 / 9 + 273.15
    }

    override fun kelvinToCelsius(kelvin: Double): Double {
        // 0K − 273.15
        return kelvin - 273.15
    }

    override fun kelvinToFahrenheit(kelvin: Double): Double {
        // (50K − 273.15) × 9/5 + 32
        return (kelvin - 273.15) * 9 / 5 + 32
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