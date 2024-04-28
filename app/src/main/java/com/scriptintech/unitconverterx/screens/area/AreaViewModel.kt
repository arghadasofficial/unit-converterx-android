package com.scriptintech.unitconverterx.screens.area

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.scriptintech.unitconverterx.components.model.UnitDropdownModel

class AreaViewModel : ViewModel() {
    private val _inputField = mutableStateOf("")
    val input: State<String> = _inputField

    private val _fExpanded = mutableStateOf(false)
    val isFExpanded: State<Boolean> = _fExpanded

    private val _sExpanded = mutableStateOf(false)
    val isSExpanded: State<Boolean> = _sExpanded

    private val _fKey = mutableStateOf("Select Unit")
    val fKey: State<String> = _fKey

    private val _sKey = mutableStateOf("Select Unit")
    val sKey: State<String> = _sKey

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
        _fKey.value = newValue
    }

    fun changeSKey(newValue: String) {
        _sKey.value = newValue
    }
}

fun getAreaUnits(): List<UnitDropdownModel> {
    return listOf(
        UnitDropdownModel(key = "km2", text = "Square kilometer", unit = "km2"),
        UnitDropdownModel(key = "ha", text = "Hectare", unit = "ha"),
        UnitDropdownModel(key = "a", text = "Are", unit = "a"),
        UnitDropdownModel(key = "m2", text = "Square meter", unit = "m2"),
        UnitDropdownModel(key = "dm2", text = "Square decimeter", unit = "dm2"),
    )
}