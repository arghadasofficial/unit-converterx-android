package com.scriptintech.unitconverterx.repository.discount

class DiscountCalculatorImpl : DiscountCalculator {
    override fun calculateDiscount(amount: String, discount: String): String {
        val actualAmount = amount.toDoubleOrNull()
        val discountAmount = discount.toDoubleOrNull()
        if (actualAmount == null || discountAmount == null) {
            return "Invalid input"
        }
        val discountedAmount = actualAmount - (actualAmount * discountAmount / 100)
        return discountedAmount.toString()
    }
}