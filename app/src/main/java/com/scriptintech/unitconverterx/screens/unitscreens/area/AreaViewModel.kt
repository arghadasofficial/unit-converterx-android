package com.scriptintech.unitconverterx.screens.unitscreens.area

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.scriptintech.unitconverterx.components.model.UDropdownModel
import com.scriptintech.unitconverterx.repository.unitrepos.area.AreaConverter
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AreaViewModel @Inject constructor(private val areaConverter: AreaConverter) : ViewModel() {

    private val _inputField = mutableStateOf("")
    val input: State<String> = _inputField

    private val _fExpanded = mutableStateOf(false)
    val isFExpanded: State<Boolean> = _fExpanded

    private val _sExpanded = mutableStateOf(false)
    val isSExpanded: State<Boolean> = _sExpanded

    private val _fromUnit = mutableStateOf("Select Unit")
    val fKey: State<String> = _fromUnit

    private val _toUnit = mutableStateOf("Select Unit")
    val sKey: State<String> = _toUnit

    private val _units = mutableStateOf<List<UDropdownModel>>(emptyList())
    val units: State<List<UDropdownModel>> = _units

    private val _result = mutableStateOf("")
    val result : State<String> = _result

    init {
        _units.value = areaConverter.getAreaUnits()
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

    fun convertArea() {
        val fromUnit = _fromUnit.value
        val toUnit = _toUnit.value
        val inputValue = _inputField.value
        val result = areaConverter.convertArea(fromUnit, toUnit, inputValue)
        _result.value = result
    }

}