package com.scriptintech.unitconverterx.repository

interface UnitDefaults {

    fun calculate(fromUnit: String, value: Double): UnitResult
    fun getUnits(): List<Unit>
    fun convertStringToDouble(input: String): Double
    fun convertDoubleToString(input: Double): String

}

data class Unit(
    val key : String,
    val name : String,
)

