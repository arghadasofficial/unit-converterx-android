package com.scriptintech.unitconverterx.repository.discount
interface DiscountCalculator {
    fun calculateDiscount(amount: String, discount: String): String
}