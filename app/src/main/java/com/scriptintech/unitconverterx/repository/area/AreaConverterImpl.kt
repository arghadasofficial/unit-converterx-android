package com.scriptintech.unitconverterx.repository.area

import com.scriptintech.unitconverterx.components.model.UDropdownModel

class AreaConverterImpl : AreaConverter {
    private val conversionFactors = mapOf(
        "km2" to 1000000.0,
        "ha" to 10000.0,
        "a" to 100.0,
        "m2" to 1.0,  // Conversion factor for m2 is 1 (by definition)
        "dm2" to 0.01,
        "cm2" to 0.0001,
        "mm2" to 0.000001,
    )
    private fun getConversionFactor(unit: String): Double {
        return conversionFactors[unit] ?: 1.0
    }

    override fun convertArea(fromUnit: String, toUnit: String, value: String): String {
        val fromFactor = getConversionFactor(fromUnit)
        val toFactor = getConversionFactor(toUnit)
        val input = value.toDoubleOrNull() ?: 0.0

        val convertedValue = input * fromFactor / toFactor

        val rounded = Math.round(convertedValue)

        return rounded.toString()
    }

    override fun getAreaUnits(): List<UDropdownModel> {
        return listOf(
            UDropdownModel(unit = "km2", text = "Square kilometer"),
            UDropdownModel(unit = "ha", text = "Hectare"),
            UDropdownModel(unit = "a", text = "Are"),
            UDropdownModel(unit = "m2", text = "Square meter"),
            UDropdownModel(unit = "dm2", text = "Square decimeter"),
            UDropdownModel(unit = "cm2", text = "Square Centimeter"),
            UDropdownModel(unit = "mm2", text = "Square millimeter"),
        )
    }
}