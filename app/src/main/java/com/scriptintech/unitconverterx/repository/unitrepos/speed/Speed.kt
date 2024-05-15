package com.scriptintech.unitconverterx.repository.unitrepos.speed

interface Speed {
    fun calculate(keyFrom: String, keyTo: String, value: Double): Double
    fun toMilePerHour(fromKey: String, input: Double): Double
    fun toKilometerPerHour(fromKey: String, input: Double): Double
    fun toMeterPerSecond(fromKey: String, input: Double): Double
    fun toFootPerSecond(fromKey: String, input: Double): Double
    fun toKnot(fromKey: String, input: Double): Double

}