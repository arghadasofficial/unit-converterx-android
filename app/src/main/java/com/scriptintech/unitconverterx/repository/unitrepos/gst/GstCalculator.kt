package com.scriptintech.unitconverterx.repository.unitrepos.gst

import com.scriptintech.unitconverterx.components.model.UDropdownModel

interface GstCalculator {
    fun calculateGst(originalPrice: String, gstPercentage: String): String
    fun getBmiPercentage(): List<UDropdownModel>
}
