package com.scriptintech.unitconverterx.screens.temperature

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TemperatureScreen(navController: NavController, temperatureViewModel: TemperatureViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Temperature") }, navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "")
                }
            })
        },
    ) {
        MainContent(paddingValues = it, viewModel = temperatureViewModel)
    }
}

@Composable
private fun MainContent(
    paddingValues: PaddingValues,
    viewModel: TemperatureViewModel
) {
    Column(modifier = Modifier.padding(paddingValues)) {
        Text(text = "aksdhoiashdiosahdiohasdiohsaidhiasdywudoashxioshadasasdasdasdjsagdisagdjasd")
    }
}

