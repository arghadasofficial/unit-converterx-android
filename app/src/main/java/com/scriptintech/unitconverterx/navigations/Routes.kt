package com.scriptintech.unitconverterx.navigations

sealed class Routes(var getRoute: String) {
    data object BmiScreen : Routes("bmi-screen")
    data object GstScreen : Routes("gst-screen")
    data object HomeScreen : Routes("home-screen")
    data object DiscountScreen : Routes("discount-screen")
    data object DataScreen : Routes("data-screen")
}