package com.scriptintech.unitconverterx.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BmiViewModel : ViewModel() {

    private val _heightInput = MutableLiveData<String>()
    var heightInput: LiveData<String> = _heightInput

    private val _weightInput = MutableLiveData<String>()
    var weightInput: LiveData<String> = _weightInput

    private val _bmiResult = MutableLiveData<String>()
    var bmiResult : LiveData<String> = _bmiResult

    private val _bmiResultType = MutableLiveData<String>()
    var bmiResultType : LiveData<String> = _bmiResultType

    fun changeHeightInput(newValue: String) {
        _heightInput.value = newValue
    }

    fun changeWeightInput(newValue: String) {
        _weightInput.value = newValue
    }

    fun calculateBmi() {
        val height = _heightInput.value?.toFloatOrNull() ?: 0f
        val weight = _weightInput.value?.toFloatOrNull() ?: 0f
        if(height == 0f || weight == 0f) {
            // TODO
            // Error Handle
        }
        val bmiValue = weight / (height / 100f) / (height / 100f)
        _bmiResult.value = String.format("%.1f", bmiValue)
        _bmiResultType.value = when {
            bmiValue < 18.5f -> "Underweight"
            bmiValue < 25f -> "Normal"
            bmiValue < 30f -> "Overweight"
            else -> "Obese"
        }
    }
}