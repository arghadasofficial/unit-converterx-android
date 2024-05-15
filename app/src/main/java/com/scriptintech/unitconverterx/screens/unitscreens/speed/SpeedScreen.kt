package com.scriptintech.unitconverterx.screens.unitscreens.speed

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
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
import com.scriptintech.unitconverterx.components.UDropdown
import com.scriptintech.unitconverterx.components.UTextFieldNumeric
import com.scriptintech.unitconverterx.components.UTriggerButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpeedScreen(navController: NavController, viewModel: SpeedViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Speed") }, navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "")
                }
            })
        },
    ) {
        MainContent(paddingValues = it, viewModel = viewModel)
    }
}

@Composable
private fun MainContent(
    paddingValues: PaddingValues,
    viewModel: SpeedViewModel,
) {
    Column(modifier = Modifier.padding(paddingValues)) {
        UTextFieldNumeric(value = viewModel.input.value, label = "Speed Input", onValueChange = {
            viewModel.changeInputValue(it)
        })
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                UTriggerButton(value = viewModel.fKey.value,
                    onClick = { viewModel.changeFState(true) })
                UDropdown(items = viewModel.units.value,
                    expanded = viewModel.isFExpanded.value,
                    onDismiss = {
                        viewModel.changeFState(false)
                    },
                    onItemClick = { fromUnit ->
                        viewModel.changeFKey(fromUnit)
                        viewModel.changeFState(false)
                    })
            }
            Column {
                UTriggerButton(value = viewModel.sKey.value,
                    onClick = { viewModel.changeSState(true) })
                UDropdown(items = viewModel.units.value,
                    expanded = viewModel.isSExpanded.value,
                    onDismiss = {
                        viewModel.changeSState(false)
                    },
                    onItemClick = { toUnit ->
                        viewModel.changeSKey(toUnit)
                        viewModel.changeSState(false)
                    })
            }
        }
        UButton(modifier = Modifier.padding(8.dp).fillMaxWidth()) {
            viewModel.calculate()
        }
        if (viewModel.result.value.isNotEmpty()) {
            Text(text = "Result: ${viewModel.result.value}")
        }
    }
}

