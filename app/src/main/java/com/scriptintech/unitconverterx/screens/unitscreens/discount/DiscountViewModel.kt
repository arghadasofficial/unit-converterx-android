package com.scriptintech.unitconverterx.screens.unitscreens.discount

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.scriptintech.unitconverterx.repository.unitrepos.discount.DiscountCalculator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DiscountViewModel @Inject constructor(private val discountCalculator: DiscountCalculator) :
    ViewModel() {

    private val _discountAmount = mutableStateOf("")
    val discountAmount: State<String> = _discountAmount

    private val _amount = mutableStateOf("")
    val amount: State<String> = _amount

    private val _result = mutableStateOf("")
    val result: State<String> = _result

    fun changeAmount(amount: String) {
        _amount.value = amount
    }

    fun changeDiscountAmount(discountAmount: String) {
        _discountAmount.value = discountAmount
    }

    fun calculateDiscount() {
        _result.value = discountCalculator.calculateDiscount(_amount.value, _discountAmount.value)
    }
}