package com.scriptintech.unitconverterx.navigations

import com.scriptintech.unitconverterx.R

data class NavigationItem(
    var title: String,
    var icon: Int,
    var route: String
)

fun getNavigationItemsList(): List<NavigationItem> {
    return listOf(
        NavigationItem(
            title = "Home",
            icon = R.drawable.home,
            route = Routes.HOME_SCREEN.getRoute
        ),
        NavigationItem(
            title = "GST",
            icon = R.drawable.tax,
            route = Routes.GST_SCREEN.getRoute
        ),
        NavigationItem(
            title = "Discount",
            icon = R.drawable.dicount_tag,
            route = Routes.DISCOUNT_SCREEN.getRoute
        ),
        NavigationItem(
            title = "BMI",
            icon = R.drawable.bmi,
            route = Routes.BMI_SCREEN.getRoute
        )
    )
}
