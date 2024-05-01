package com.scriptintech.unitconverterx.screens.bmi

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.scriptintech.unitconverterx.repository.bmi.BmiCalculator
import com.scriptintech.unitconverterx.repository.bmi.BmiResult
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BmiViewModel @Inject constructor(private val bmiCalculator: BmiCalculator) : ViewModel() {

    private val _height = mutableStateOf("")
    val height: State<String> = _height

    private val _weight = mutableStateOf("")
    val weight: State<String> = _weight

    private val _bmiResult = mutableStateOf(BmiResult(0.0,"",""))
    val bmiResult : State<BmiResult> = _bmiResult

    fun changeHeight(newValue: String) {
        _height.value = newValue
    }

    fun changeWeight(newValue: String) {
        _weight.value = newValue
    }
    fun calculateBmi() {
        if (validateInput()) {
            try {
                val bmiResult = bmiCalculator.calculateBmi(_height.value, _weight.value)
                _bmiResult.value = bmiResult
            } catch (e: Exception) {
                // Handle exceptions from BmiCalculator (e.g., show error message)
                _bmiResult.value = BmiResult(0.0, "Error", "")
            }
        } else {
            // Handle invalid user input (e.g., show error message)
        }
    }
    private fun validateInput(): Boolean {
        val height = _height.value.trim()
        val weight = _weight.value.trim()
        if (height.isEmpty() || weight.isEmpty()) {
            // Show error message for empty fields
            return false
        }
        try {
            height.toDouble()
            weight.toDouble()
        } catch (e: NumberFormatException) {
            // Show error message for invalid input (non-numeric)
            return false
        }
        return true
    }
}