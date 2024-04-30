package com.scriptintech.unitconverterx.screens.bmi

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.scriptintech.unitconverterx.repository.bmi.BmiCalculator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class BmiViewModel @Inject constructor(private val bmiCalculator: BmiCalculator) : ViewModel() {

    private val _height = mutableStateOf("")
    private val _weight = mutableStateOf("")
    private val _bmi = mutableDoubleStateOf(0.0)
    private val _category = mutableStateOf("")
    private val _suggestion = mutableStateOf("")

    val height: State<String> = _height
    val weight: State<String> = _weight

    val bmi: State<Double> = _bmi
    val category: State<String> = _category
    val suggestion: State<String> = _suggestion
    fun changeHeight(newValue: String) {
        _height.value = newValue
    }

    fun changeWeight(newValue: String) {
        _weight.value = newValue
    }

    private fun validateInput(): Boolean {
        return true
    }
    fun calculateBmi() {
        if (validateInput()) {
            val bmiResult = bmiCalculator.calculateBmi(_height.value, _weight.value)
            _bmi.doubleValue = bmiResult.bmi
            _category.value = bmiResult.category
            _suggestion.value = bmiResult.suggestion
        }
    }
}