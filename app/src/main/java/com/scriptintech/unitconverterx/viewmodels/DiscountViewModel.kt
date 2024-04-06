package com.scriptintech.unitconverterx.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DiscountViewModel : ViewModel() {

    private val _originalPrice = MutableLiveData<String>("100")
    val originalPrice: LiveData<String> = _originalPrice

    private val _discount = MutableLiveData<String>("10")
    val discount: LiveData<String> = _discount

    private val _finalPrice = MutableLiveData<String>("")
    val finalPrice: LiveData<String> = _finalPrice

    init {
        calculateDiscount()
    }

    fun changeOriginalPrice(newValue: String) {
        _originalPrice.value = newValue
        calculateDiscount()
    }

    fun changeDiscount(newValue: String) {
        _discount.value = newValue
        calculateDiscount()
    }

    private fun calculateDiscount() {
        val originalPriceValue = _originalPrice.value?.toDoubleOrNull() ?: return
        val discountValue = _discount.value?.toDoubleOrNull() ?: return

        val discountedAmount = originalPriceValue * (discountValue / 100)
        val finalPriceValue = originalPriceValue - discountedAmount

        _finalPrice.value = finalPriceValue.toString()
    }
}