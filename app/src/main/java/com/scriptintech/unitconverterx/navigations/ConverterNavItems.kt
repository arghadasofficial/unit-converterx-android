package com.scriptintech.unitconverterx.navigations

import com.scriptintech.unitconverterx.R

data class ConverterNavItems(
    var title: String, var icon: Int, var route: String
)

fun getNavigationItemsList(): List<ConverterNavItems> {
    return listOf(
        ConverterNavItems(
            title = "Gst", icon = R.drawable.tax, route = Routes.GstScreen.getRoute
        ),
        ConverterNavItems(
            title = "Discount",
            icon = R.drawable.dicount_tag,
            route = Routes.DiscountScreen.getRoute
        ),
        ConverterNavItems(
            title = "Bmi", icon = R.drawable.bmi, route = Routes.BmiScreen.getRoute
        ),
        ConverterNavItems(
            title = "Area", icon = R.drawable.area, route = Routes.AreaScreen.getRoute
        ),
        ConverterNavItems(
            title = "Time", icon = R.drawable.time, route = Routes.TimeScreen.getRoute
        ),
        ConverterNavItems(
            title = "Temperature",
            icon = R.drawable.temperature,
            route = Routes.TemperatureScreen.getRoute
        ),
        ConverterNavItems(
            title = "Speed", icon = R.drawable.speed, route = Routes.SpeedScreen.getRoute
        ),
    )
}
