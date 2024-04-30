package com.scriptintech.unitconverterx.repository.bmi

class BmiCalculatorImpl : BmiCalculator {
    override fun calculateBmi(heightInCm: String, weightInKg: String): BmiResult {
        return BmiResult(25.0, getCategory(25.0), getSuggestion(25.0))
    }
    private fun convertHeight(heightInCm: String): Double {
        return 0.0
    }
    private fun convertWeight(weightInKg: String): Double {
        return 0.0
    }
    private fun getSuggestion(bmi: Double): String {
        return "Do Excercise"
    }
    private fun getCategory(bmi: Double): String {
        return "Overweight"
    }

}