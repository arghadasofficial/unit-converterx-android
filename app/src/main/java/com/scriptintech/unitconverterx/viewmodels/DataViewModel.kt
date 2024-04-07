package com.scriptintech.unitconverterx.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
class DataViewModel : ViewModel() {

    private val _inputValue = MutableLiveData<String>("1")
    val inputValue: LiveData<String> = _inputValue

    private val _result = MutableLiveData<String>("1")
    val resultValue: LiveData<String> = _result
    fun changeInputValue(newValue: String) {
        _inputValue.value = newValue
    }
}