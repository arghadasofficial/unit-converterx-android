package com.scriptintech.unitconverterx.navigations

import com.scriptintech.unitconverterx.R

data class NavigationItem(
    var title: String, var icon: Int, var route: String
)

fun getNavigationItemsList(): List<NavigationItem> {
    return listOf(
        NavigationItem(
            title = "Home", icon = R.drawable.home, route = Routes.HomeScreen.getRoute
        ), NavigationItem(
            title = "Gst", icon = R.drawable.tax, route = Routes.GstScreen.getRoute
        ), NavigationItem(
            title = "Discount",
            icon = R.drawable.dicount_tag,
            route = Routes.DiscountScreen.getRoute
        ), NavigationItem(
            title = "Data", icon = R.drawable.data, route = Routes.DataScreen.getRoute
        ), NavigationItem(
            title = "Bmi", icon = R.drawable.bmi, route = Routes.BmiScreen.getRoute
        )
    )
}
