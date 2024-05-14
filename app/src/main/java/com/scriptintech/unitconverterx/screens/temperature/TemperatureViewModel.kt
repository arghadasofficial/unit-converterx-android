package com.scriptintech.unitconverterx.screens.temperature

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.scriptintech.unitconverterx.components.model.UDropdownModel
import com.scriptintech.unitconverterx.repository.temperature.Temperature
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TemperatureViewModel @Inject constructor(private val temperatureConverter: Temperature) :
    ViewModel() {
    private val _inputField = mutableStateOf("")
    val input: State<String> = _inputField

    private val _fExpanded = mutableStateOf(false)
    val isFExpanded: State<Boolean> = _fExpanded

    private val _sExpanded = mutableStateOf(false)
    val isSExpanded: State<Boolean> = _sExpanded

    private val _fromUnit = mutableStateOf("")
    val fKey: State<String> = _fromUnit

    private val _toUnit = mutableStateOf("")
    val sKey: State<String> = _toUnit

    private val _units = mutableStateOf<List<UDropdownModel>>(emptyList())
    val units: State<List<UDropdownModel>> = _units

    private val _result = mutableStateOf("")
    val result: State<String> = _result

    init {
        _units.value = temperatureConverter.getUnits()
        if (_units.value.isNotEmpty()) {
            _fromUnit.value = _units.value[0].unit
            _toUnit.value = _units.value[1].unit
        }
    }

    fun changeInputValue(newValue: String) {
        _inputField.value = newValue
    }

    fun changeFState(newValue: Boolean) {
        _fExpanded.value = newValue
    }

    fun changeSState(newValue: Boolean) {
        _sExpanded.value = newValue
    }

    fun changeFKey(newValue: String) {
        _fromUnit.value = newValue
    }

    fun changeSKey(newValue: String) {
        _toUnit.value = newValue
    }

    fun calculate() {
        if (_inputField.value.isNotEmpty()) {
            _result.value = temperatureConverter.calculate(
                _fromUnit.value,
                _toUnit.value,
                temperatureConverter.convertStringToDouble(_inputField.value)
            ).toString()
        }
    }
}