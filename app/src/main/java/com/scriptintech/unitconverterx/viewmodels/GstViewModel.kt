package com.scriptintech.unitconverterx.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
class GstViewModel : ViewModel() {

    private val _originalPrice = MutableLiveData<String>("100")
    val originalPrice : LiveData<String> = _originalPrice

    private val _gst = MutableLiveData<String>("18")
    val gst : LiveData<String> = _gst

    private val _finalPrice = MutableLiveData<String>()
    val finalPrice : LiveData<String> = _finalPrice

    private val _gstDropDown = MutableLiveData<Boolean>()
    val gstDropDownExpanded : LiveData<Boolean> = _gstDropDown

    init {
        calculateGst()
    }

    fun onChangeDropDownValue(newValue: Boolean) {
        _gstDropDown.value = newValue
        calculateGst()
    }

    fun onChangeGstValue(newValue: String) {
        _gst.value = newValue
        calculateGst()
    }

    fun onChangeOrigialPrice(newValue: String) {
        _originalPrice.value = newValue
        calculateGst()
    }

    private fun calculateGst() {
        val originalPriceValue = _originalPrice.value?.toDoubleOrNull() ?: return
        val gstValue = _gst.value?.toDoubleOrNull() ?: return

        val finalPriceValue = originalPriceValue * (1 + gstValue / 100)
        _finalPrice.value = finalPriceValue.toString()
    }
}