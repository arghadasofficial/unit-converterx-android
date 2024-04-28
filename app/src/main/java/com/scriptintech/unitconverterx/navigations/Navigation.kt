package com.scriptintech.unitconverterx.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun UnitNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.HomeScreen.getRoute) {

    }
}