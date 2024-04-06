package com.scriptintech.unitconverterx.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.scriptintech.unitconverterx.viewmodels.GstViewModel

@Composable
fun GstScreen(viewModel: GstViewModel, paddingValues: PaddingValues) {
    val originalPrice by viewModel.originalPrice.observeAsState(initial = "0")
    val gst by viewModel.gst.observeAsState("3")
    val finalPrice by viewModel.finalPrice.observeAsState("0")
    val isDropDownExpanded by viewModel.gstDropDownExpanded.observeAsState(initial = false)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
    ) {
        GstUtil(
            originalPrice,
            gst,
            finalPrice,
            isDropDownExpanded,
            onDropDownExpanded = { viewModel.onChangeDropDownValue(it) },
            onDropDownSelectedValue = { viewModel.onChangeGstValue(it) },
            onOriginalPriceUpdate = { viewModel.onChangeOrigialPrice(it) },
        )
    }
}

@Composable
private fun GstUtil(
    originalPrice: String,
    gst: String,
    finalPrice: String,
    isDropDownExpanded: Boolean,
    onDropDownExpanded: (Boolean) -> Unit,
    onDropDownSelectedValue: (String) -> Unit,
    onOriginalPriceUpdate: (String) -> Unit,
) {
    Column {
        OutlinedTextField(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text(text = "Original Price") },
            value = originalPrice,
            onValueChange = { onOriginalPriceUpdate(it) })

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(text = "select Gst percentage ")
            Column {
                GstDropDown(gst = gst,
                    isDropDownExpanded = isDropDownExpanded,
                    onDropDownExpanded = { onDropDownExpanded(it) },
                    onDropDownSelectedValue = { onDropDownSelectedValue(it) })
            }
        }

        OutlinedTextField(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text(text = "Final Price") },
            value = finalPrice,
            onValueChange = { })
    }
}

@Composable
private fun GstDropDown(
    gst: String,
    isDropDownExpanded: Boolean,
    onDropDownExpanded: (Boolean) -> Unit,
    onDropDownSelectedValue: (String) -> Unit
) {
    OutlinedButton(onClick = { onDropDownExpanded(true) }) {
        Text(text = "${gst}%")
        Icon(Icons.Default.ArrowDropDown, contentDescription = null)
    }
    DropdownMenu(expanded = isDropDownExpanded, onDismissRequest = { onDropDownExpanded(false) }) {
        DropdownMenuItem(text = { Text(text = "3%") }, onClick = {
            onDropDownExpanded(false)
            onDropDownSelectedValue("3")
        })
        DropdownMenuItem(text = { Text(text = "5%") }, onClick = {
            onDropDownExpanded(false)
            onDropDownSelectedValue("5")
        })
        DropdownMenuItem(text = { Text(text = "12%") }, onClick = {
            onDropDownExpanded(false)
            onDropDownSelectedValue("12")
        })
        DropdownMenuItem(text = { Text(text = "18%") }, onClick = {
            onDropDownExpanded(false)
            onDropDownSelectedValue("18")
        })
        DropdownMenuItem(text = { Text(text = "28%") }, onClick = {
            onDropDownExpanded(false)
            onDropDownSelectedValue("28")
        })
    }
}