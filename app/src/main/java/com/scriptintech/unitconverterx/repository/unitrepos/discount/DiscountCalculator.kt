package com.scriptintech.unitconverterx.repository.unitrepos.discount
interface DiscountCalculator {
    fun calculateDiscount(amount: String, discount: String): String
}