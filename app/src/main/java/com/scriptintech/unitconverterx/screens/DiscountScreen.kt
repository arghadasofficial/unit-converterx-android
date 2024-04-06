package com.scriptintech.unitconverterx.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.scriptintech.unitconverterx.viewmodels.DiscountViewModel

@Composable
fun DiscountScreen(viewModel: DiscountViewModel, paddingValues: PaddingValues) {
    val originalPrice by viewModel.originalPrice.observeAsState(initial = "")
    val discount by viewModel.discount.observeAsState(initial = "")
    val finalPrice by viewModel.finalPrice.observeAsState(initial = "0")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        DiscountUtil(
            originalPrice,
            discount,
            finalPrice,
            onOriginalValueChange = {
                viewModel.changeOriginalPrice(it)
            },
            onDiscountValueChange = {
                viewModel.changeDiscount(it)
            })
    }
}

@Composable
fun DiscountUtil(
    originalPrice: String,
    discount: String,
    finalPrice: String,
    onOriginalValueChange: (String) -> Unit,
    onDiscountValueChange: (String) -> Unit
) {
    Column {
        OutlinedTextField(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text(text = "Original Price") },
            value = originalPrice,
            onValueChange = { onOriginalValueChange(it) })

        OutlinedTextField(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text(text = "Discount (% off)") },
            value = discount,
            onValueChange = { onDiscountValueChange(it) })

        OutlinedTextField(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text(text = "Final Price") },
            value = finalPrice,
            onValueChange = { })
    }
}
