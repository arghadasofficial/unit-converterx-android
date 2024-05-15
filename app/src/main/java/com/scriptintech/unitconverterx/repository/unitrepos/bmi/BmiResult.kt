package com.scriptintech.unitconverterx.repository.unitrepos.bmi

/**
 * Represents the outcome of a Body Mass Index (BMI) calculation.
 *
 * @property bmi The calculated BMI value as a double.
 * @property category The BMI category based on the calculated value (e.g., Underweight, Normal, Overweight, Obese) as a string.
 * @property suggestion A suggestion based on the BMI category as a string (optional).
 */
data class BmiResult(
    val bmi: Double,
    val category: String,
    val suggestion: String,
)
