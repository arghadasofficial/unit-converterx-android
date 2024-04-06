package com.scriptintech.unitconverterx.navigations

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItem(
    var title: String,
    var icon: ImageVector,
    var route: String
)

fun getNavigationItemsList(): List<NavigationItem> {
    return listOf(
        NavigationItem(
            title = "GST",
            icon = Icons.Filled.Home,
            route = Routes.GST_SCREEN.getRoute
        ),
        NavigationItem(
            title = "BMI",
            icon = Icons.Filled.Home,
            route = Routes.BMI_SCREEN.getRoute
        )
    )
}
