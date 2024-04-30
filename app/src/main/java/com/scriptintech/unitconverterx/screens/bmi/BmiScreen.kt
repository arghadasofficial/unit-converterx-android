package com.scriptintech.unitconverterx.screens.bmi

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.scriptintech.unitconverterx.components.UButton
import com.scriptintech.unitconverterx.components.UTextField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BmiScreen(navController: NavController, bmiViewModel: BmiViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "BMI") }, navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "")
                }
            })
        },
    ) {
        MainContent(paddingValues = it, bmiViewModel)
    }
}

@Composable
private fun MainContent(
    paddingValues: PaddingValues, viewModel: BmiViewModel
) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxWidth()
    ) {
        UTextField(value = viewModel.height.value, label = "Height (cm)") {
            viewModel.changeHeight(it)
        }
        UTextField(value = viewModel.weight.value, label = "Weight (kg)") {
            viewModel.changeWeight(it)
        }
        UButton(modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(), value = "Calculate", onClick = { viewModel.calculateBmi()
        })
        Text(text = viewModel.bmi.toString())
        Text(text = viewModel.category.value)
        Text(text = viewModel.suggestion.value)
    }
}

