package com.scriptintech.unitconverterx.navigations

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.scriptintech.unitconverterx.screens.area.AreaScreen
import com.scriptintech.unitconverterx.screens.area.AreaViewModel
import com.scriptintech.unitconverterx.screens.bmi.BmiScreen
import com.scriptintech.unitconverterx.screens.bmi.BmiViewModel
import com.scriptintech.unitconverterx.screens.data.DataScreen
import com.scriptintech.unitconverterx.screens.discount.DiscountScreen
import com.scriptintech.unitconverterx.screens.discount.DiscountViewModel
import com.scriptintech.unitconverterx.screens.gst.GstScreen
import com.scriptintech.unitconverterx.screens.gst.GstViewModel
import com.scriptintech.unitconverterx.screens.home.HomeScreen
import com.scriptintech.unitconverterx.screens.numeral.NumeralScreen
import com.scriptintech.unitconverterx.screens.speed.SpeedScreen
import com.scriptintech.unitconverterx.screens.temperature.TemperatureScreen
import com.scriptintech.unitconverterx.screens.time.TimeScreen

@Composable
fun UnitNavigation() {
    val areaViewModel: AreaViewModel = viewModel()
    val bmiViewModel: BmiViewModel = viewModel()
    val discountViewModel: DiscountViewModel = viewModel()
    val gstViewModel: GstViewModel = viewModel()

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.HomeScreen.getRoute) {
        composable(route = Routes.HomeScreen.getRoute) {
            HomeScreen(navController = navController)
        }
        composable(route = Routes.BmiScreen.getRoute) {
            BmiScreen(navController = navController, bmiViewModel)
        }
        composable(route = Routes.DataScreen.getRoute) {
            DataScreen(navController = navController)
        }
        composable(route = Routes.DiscountScreen.getRoute) {
            DiscountScreen(navController = navController, discountViewModel)
        }
        composable(route = Routes.GstScreen.getRoute) {
            GstScreen(navController = navController, gstViewModel)
        }
        composable(route = Routes.NumeralScreen.getRoute) {
            NumeralScreen(navController = navController)
        }
        composable(route = Routes.SpeedScreen.getRoute) {
            SpeedScreen(navController = navController)
        }
        composable(route = Routes.TimeScreen.getRoute) {
            TimeScreen(navController = navController)
        }
        composable(route = Routes.AreaScreen.getRoute) {
            AreaScreen(navController = navController, areaViewModel)
        }
        composable(route = Routes.TemperatureScreen.getRoute) {
            TemperatureScreen(navController = navController)
        }
    }
}