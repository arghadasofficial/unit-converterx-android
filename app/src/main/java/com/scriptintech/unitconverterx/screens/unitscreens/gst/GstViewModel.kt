package com.scriptintech.unitconverterx.screens.unitscreens.gst

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.scriptintech.unitconverterx.components.model.UDropdownModel
import com.scriptintech.unitconverterx.repository.unitrepos.gst.GstCalculator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GstViewModel @Inject constructor(private val gstCalculator: GstCalculator) : ViewModel() {

    private val _originalPrice = mutableStateOf("")
    val originalPrice: State<String> = _originalPrice

    private val _gstPercentageDropdownState = mutableStateOf(false)
    val dropdownState: State<Boolean> = _gstPercentageDropdownState

    private val _discountedKey = mutableStateOf("")
    val discountedKey: State<String> = _discountedKey

    private val _gst = mutableStateOf("")
    val gst: State<String> = _gst

    private val _gstPercentageList = mutableStateOf<List<UDropdownModel>>(emptyList())
    val gstPercentageList: State<List<UDropdownModel>> = _gstPercentageList

    init {
        _gstPercentageList.value = gstCalculator.getBmiPercentage()
    }

    fun changeOriginalPrice(value: String) {
        _originalPrice.value = value
    }

    fun changeDiscountedKey(value: String) {
        _discountedKey.value = value
    }

    fun changeDropdownState(value: Boolean) {
        _gstPercentageDropdownState.value = value
    }
    fun calculateGst() {
        if (_originalPrice.value.isNotEmpty()) {
            _gst.value = gstCalculator.calculateGst(_originalPrice.value, _discountedKey.value)
        }
    }
}