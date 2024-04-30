package com.scriptintech.unitconverterx.repository.bmi

interface BmiCalculator {
    fun calculateBmi(heightInCm: String, weightInKg: String): BmiResult
}
data class BmiResult(
    val bmi: Double,
    val category: String,
    val suggestion: String,
)
