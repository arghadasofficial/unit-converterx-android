package com.scriptintech.unitconverterx.repository.temperature

interface Temperature {
    fun calculate(keyFrom: String, keyTo: String, value: Double): Double
}