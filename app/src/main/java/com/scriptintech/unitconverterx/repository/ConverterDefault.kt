package com.scriptintech.unitconverterx.repository

import com.scriptintech.unitconverterx.components.model.UDropdownModel

interface ConverterDefault {
    fun convertStringToDouble(input: String): Double
    fun getUnits(): List<UDropdownModel>
}