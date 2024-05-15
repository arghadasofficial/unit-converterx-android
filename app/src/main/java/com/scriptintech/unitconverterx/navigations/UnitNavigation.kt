package com.scriptintech.unitconverterx.navigations

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.scriptintech.unitconverterx.screens.unitscreens.area.AreaScreen
import com.scriptintech.unitconverterx.screens.unitscreens.area.AreaViewModel
import com.scriptintech.unitconverterx.screens.unitscreens.bmi.BmiScreen
import com.scriptintech.unitconverterx.screens.unitscreens.bmi.BmiViewModel
import com.scriptintech.unitconverterx.screens.unitscreens.discount.DiscountScreen
import com.scriptintech.unitconverterx.screens.unitscreens.discount.DiscountViewModel
import com.scriptintech.unitconverterx.screens.unitscreens.gst.GstScreen
import com.scriptintech.unitconverterx.screens.unitscreens.gst.GstViewModel
import com.scriptintech.unitconverterx.screens.HomeScreen
import com.scriptintech.unitconverterx.screens.unitscreens.speed.SpeedScreen
import com.scriptintech.unitconverterx.screens.unitscreens.speed.SpeedViewModel
import com.scriptintech.unitconverterx.screens.unitscreens.temperature.TemperatureScreen
import com.scriptintech.unitconverterx.screens.unitscreens.temperature.TemperatureViewModel
import com.scriptintech.unitconverterx.screens.unitscreens.time.TimeScreen
import com.scriptintech.unitconverterx.screens.unitscreens.time.TimeViewModel

@Composable
fun UnitNavigation() {
    val areaViewModel: AreaViewModel = viewModel()
    val bmiViewModel: BmiViewModel = viewModel()
    val discountViewModel: DiscountViewModel = viewModel()
    val gstViewModel: GstViewModel = viewModel()
    val temperatureViewModel: TemperatureViewModel = viewModel()
    val speedViewModel: SpeedViewModel = viewModel()
    val timeViewModel: TimeViewModel = viewModel()

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.TimeScreen.getRoute) {
        composable(route = Routes.HomeScreen.getRoute) {
            HomeScreen(navController = navController)
        }
        composable(route = Routes.BmiScreen.getRoute) {
            BmiScreen(navController = navController, bmiViewModel)
        }
        composable(route = Routes.DiscountScreen.getRoute) {
            DiscountScreen(navController = navController, discountViewModel)
        }
        composable(route = Routes.GstScreen.getRoute) {
            GstScreen(navController = navController, gstViewModel)
        }
        composable(route = Routes.SpeedScreen.getRoute) {
            SpeedScreen(navController = navController, viewModel = speedViewModel)
        }
        composable(route = Routes.AreaScreen.getRoute) {
            AreaScreen(navController = navController, areaViewModel)
        }
        composable(route = Routes.TemperatureScreen.getRoute) {
            TemperatureScreen(navController = navController, temperatureViewModel)
        }
        composable(route = Routes.TimeScreen.getRoute) {
            TimeScreen(navController = navController, timeViewModel)
        }
    }
}