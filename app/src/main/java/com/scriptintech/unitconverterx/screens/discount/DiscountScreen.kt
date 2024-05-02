package com.scriptintech.unitconverterx.screens.discount

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
import com.scriptintech.unitconverterx.components.UTextFieldNumeric

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiscountScreen(navController: NavController, discountViewModel: DiscountViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Discount") }, navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "")
                }
            })
        },
    ) {
        MainContent(paddingValues = it, viewModel = discountViewModel)
    }
}

@Composable
private fun MainContent(
    paddingValues: PaddingValues,
    viewModel: DiscountViewModel
) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxWidth()
    ) {
        UTextFieldNumeric(value = viewModel.amount.value, label = "Amount") {
            viewModel.changeAmount(it)
        }
        UTextFieldNumeric(value = viewModel.discountAmount.value, label = "Discounted Amount") {
            viewModel.changeDiscountAmount(it)
        }
        UButton(modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(), value = "Calculate", onClick = {
            viewModel.calculateDiscount()
        })
        Text(text = "Discount: ${viewModel.result.value}")
    }
}