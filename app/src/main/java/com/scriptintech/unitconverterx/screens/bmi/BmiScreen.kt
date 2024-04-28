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
fun BmiScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "BMI") }, navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "")
                }
            })
        },
    ) {
        MainContent(paddingValues = it)
    }
}

@Composable
private fun MainContent(
    paddingValues: PaddingValues,
) {
    Column(modifier = Modifier
        .padding(paddingValues)
        .fillMaxWidth()) {
        UTextField(value = "", label = "Height (cm)") {

        }
        UTextField(value = "", label = "Weight (kg)") {

        }
        UButton(modifier = Modifier.padding(8.dp).fillMaxWidth(), value = "Calculate",onClick = {})
    }
}

