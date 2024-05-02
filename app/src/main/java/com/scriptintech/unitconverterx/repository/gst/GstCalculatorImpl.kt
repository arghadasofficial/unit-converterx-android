package com.scriptintech.unitconverterx.repository.gst

import com.scriptintech.unitconverterx.components.model.UDropdownModel

class GstCalculatorImpl : GstCalculator {
    override fun calculateGst(originalPrice: String, gstPercentage: String): String {
        val price = originalPrice.toDouble()
        val percentage = gstPercentage.toDouble()
        val gstAmount = price * percentage / 100
        val totalPrice = price + gstAmount
        return totalPrice.toString()
    }

    override fun getBmiPercentage(): List<UDropdownModel> {
        return listOf(
            UDropdownModel(unit = "3", text = "3%"),
            UDropdownModel(unit = "5", text = "5%"),
            UDropdownModel(unit = "12", text = "12%"),
            UDropdownModel(unit = "18", text = "18%"),
            UDropdownModel(unit = "28", text = "28%"),
        )
    }
}