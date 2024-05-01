package com.scriptintech.unitconverterx.repository.bmi

class BmiCalculatorImpl : BmiCalculator {
    override fun calculateBmi(height: String, weight: String): BmiResult {
        val heightInMeters = convertHeight(height)
        val weightInKg = convertWeight(weight)
        val bmi = weightInKg / (heightInMeters * heightInMeters)
        val category = getCategory(bmi)
        val suggestion = getSuggestion(bmi)
        val roundedBmi = Math.round(bmi * 10.0) / 10.0 // Round to 1 decimal places
        return BmiResult(roundedBmi, category, suggestion)
    }
    private fun convertHeight(heightInCm: String): Double {
        try {
            val heightInDouble = heightInCm.toDouble()
            return heightInDouble / 100.0
        } catch (e: NumberFormatException) {
            throw Exception("Invalid height input")
        }
    }
    private fun convertWeight(weightInKg: String): Double {
        try {
            return weightInKg.toDouble()
        } catch (e: NumberFormatException) {
            // Handle invalid input (e.g., throw exception or return default value)
            throw Exception("Invalid weight input")
        }
    }
    private fun getSuggestion(bmi: Double): String {
        return when (bmi) {
            in 18.5..24.9 -> "Normal"
            in 25.0..29.9 -> "Overweight"
            else -> "Other" // You can further categorize or handle edge cases
        }
    }
    private fun getCategory(bmi: Double): String {
        return when (bmi) {
            in 18.5..24.9 -> "Maintain a healthy lifestyle!"
            in 25.0..29.9 -> "Consider consulting a doctor or nutritionist for weight management advice."
            else -> "Consult a doctor to discuss your BMI." // Customize based on category
        }
    }

}