package com.scriptintech.unitconverterx.navigations

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItems(
    val label: String,
    val icon: ImageVector,
)

fun getBottomNavItemsList() : List<BottomNavItems> {
    return listOf(
        BottomNavItems("Favourites", Icons.Default.FavoriteBorder),
        BottomNavItems("Categories", Icons.Default.Menu),
        BottomNavItems("Tools", Icons.Default.Build),
        BottomNavItems("History", Icons.Default.Info),
        BottomNavItems("Settings", Icons.Default.Settings),
    )
}