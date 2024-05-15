package com.scriptintech.unitconverterx.screens.unitscreens.time

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.scriptintech.unitconverterx.repository.Unit
import com.scriptintech.unitconverterx.repository.UnitResult
import com.scriptintech.unitconverterx.repository.unitrepos.time.TimeImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TimeViewModel @Inject constructor(private val timeConverter: TimeImpl) : ViewModel() {

    private val _inputTime = mutableStateOf("")
    val inputTime: State<String> = _inputTime

    private val _isSelectorExpanded = mutableStateOf(false)
    val isSelectorExpanded: State<Boolean> = _isSelectorExpanded

    private val _dropdownOptions = mutableStateOf<List<Unit>>(emptyList())
    val dropdownOptions: State<List<Unit>> = _dropdownOptions

    private val _selectedDropdownOption = mutableStateOf("")

    private val _inputLabel = mutableStateOf("Enter Value & Select Unit")
    val inputLabel: State<String> = _inputLabel

    private val _unitResult = mutableStateOf(UnitResult("", emptyList()))
    val unitResult: State<UnitResult> = _unitResult

    init {
        _dropdownOptions.value = timeConverter.getUnits()
        if (_dropdownOptions.value.isNotEmpty()) {
            _selectedDropdownOption.value = _dropdownOptions.value[0].name
        }
    }

    fun changeInputLabel(label: String) {
        _inputLabel.value = label
    }

    fun changeDropdownSelectedOption(option: String) {
        _selectedDropdownOption.value = option
    }

    fun changeIsSelectorExpanded(expanded: Boolean) {
        _isSelectorExpanded.value = expanded
    }

    fun changeInputTime(time: String) {
        _inputTime.value = time
    }

    fun calculate() {
        if (_inputTime.value.isNotEmpty() && _selectedDropdownOption.value.isNotEmpty()) {
            _unitResult.value = timeConverter.calculate(
                _selectedDropdownOption.value,
                timeConverter.convertStringToDouble(_inputTime.value)
            )
        }
    }

}