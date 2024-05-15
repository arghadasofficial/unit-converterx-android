package com.scriptintech.unitconverterx.repository.unitrepos.bmi

interface BmiCalculator {
    /**
     * Calculates the Body Mass Index (BMI) based on provided height and weight.
     *
     * @param height Height of the person in centimeters (cm) as a string.
     * @param weight Weight of the person in kilograms (kg) as a string.
     * @return A BmiResult object containing the calculated BMI value, category, and suggestion.
     */
    fun calculateBmi(height: String, weight: String): BmiResult
}