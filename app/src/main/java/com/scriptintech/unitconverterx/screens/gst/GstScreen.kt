package com.scriptintech.unitconverterx.screens.gst

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
import com.scriptintech.unitconverterx.components.UButton
import com.scriptintech.unitconverterx.components.UDropdown
import com.scriptintech.unitconverterx.components.UTextFieldNumeric
import com.scriptintech.unitconverterx.components.UTriggerButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GstScreen(navController: NavController, gstViewModel: GstViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "GST") }, navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "")
                }
            })
        },
    ) {
        MainContent(paddingValues = it, viewModel = gstViewModel)
    }
}

@Composable
private fun MainContent(
    paddingValues: PaddingValues, viewModel: GstViewModel
) {
    Column(
        modifier = Modifier.padding(paddingValues)
    ) {
        UTextFieldNumeric(value = viewModel.originalPrice.value,
            label = "Original Price",
            onValueChange = {
                viewModel.changeOriginalPrice(it)
            })
        UTriggerButton(value = viewModel.discountedKey.value,
            onClick = { viewModel.changeDropdownState(true) })
        UDropdown(items = viewModel.gstPercentageList.value,
            expanded = viewModel.dropdownState.value,
            onDismiss = {
                viewModel.changeDropdownState(false)
            },
            onItemClick = { fromUnit ->
                viewModel.changeDiscountedKey(fromUnit)
                viewModel.changeDropdownState(false)
            })

        UButton(onClick = {
            viewModel.calculateGst()
        })

        if (viewModel.gst.value.isNotEmpty()) {
            Text(text = "Gst: ${viewModel.gst.value}")
        }
    }
}