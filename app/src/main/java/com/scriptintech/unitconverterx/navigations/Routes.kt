package com.scriptintech.unitconverterx.navigations

sealed class Routes(var getRoute: String) {
    object BMI_SCREEN : Routes("bmiscreen")
    object GST_SCREEN : Routes("gstscreen")
    object HOME_SCREEN : Routes("homescreen")
    object DISCOUNT_SCREEN: Routes("discountscreen")
}