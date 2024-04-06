package com.scriptintech.unitconverterx.navigations

import android.content.Context
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.scriptintech.unitconverterx.screens.BmiScreen
import com.scriptintech.unitconverterx.screens.DiscountScreen
import com.scriptintech.unitconverterx.screens.GstScreen
import com.scriptintech.unitconverterx.screens.HomeScreen
import com.scriptintech.unitconverterx.viewmodels.BmiViewModel
import com.scriptintech.unitconverterx.viewmodels.DiscountViewModel
import com.scriptintech.unitconverterx.viewmodels.GstViewModel
import com.scriptintech.unitconverterx.viewmodels.HomeViewModel

@Composable
fun SetupNavGraph(
    navHostController: NavHostController, paddingValues: PaddingValues, context: Context
) {
    val bmiViewModel: BmiViewModel = viewModel()
    val homeViewModel: HomeViewModel = viewModel()
    val gstViewModel: GstViewModel = viewModel()
    val discountViewModel: DiscountViewModel = viewModel()

    NavHost(navController = navHostController, startDestination = Routes.HOME_SCREEN.getRoute) {
        composable(Routes.HOME_SCREEN.getRoute) {
            HomeScreen(
                viewModel = homeViewModel,
                navHostController = navHostController,
                paddingValues = paddingValues
            )
        }
        composable(Routes.BMI_SCREEN.getRoute) {
            BmiScreen(context = context, viewModel = bmiViewModel, paddingValues = paddingValues)
        }
        composable(Routes.GST_SCREEN.getRoute) {
            GstScreen(paddingValues = paddingValues, viewModel = gstViewModel)
        }
        composable(Routes.DISCOUNT_SCREEN.getRoute) {
            DiscountScreen(paddingValues = paddingValues, viewModel = discountViewModel)
        }
    }
}