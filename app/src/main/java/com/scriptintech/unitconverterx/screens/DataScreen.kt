package com.scriptintech.unitconverterx.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.scriptintech.unitconverterx.components.SimpleDropDownMenu
import com.scriptintech.unitconverterx.components.SimpleInputField
import com.scriptintech.unitconverterx.viewmodels.DataViewModel

@Composable
fun DataScreen(paddingValues: PaddingValues, viewModel: DataViewModel) {
    val inputValue by viewModel.inputValue.observeAsState()
    val resultValue by viewModel.resultValue.observeAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
    ) {
        DataUtil(value = inputValue ?: "0",
            label = "Data Value",
            resultValue = resultValue ?: "0",
            resultLabel = "Converted Value",
            onValueUpdate = { viewModel.changeInputValue(it) },
            onFirstDropDownExpanded = {},
            onFirstDropDownSelectedValue = {},
            onSecondDropDownExpanded = {},
            onSecondDropDownSelectedValue = {})
    }
}

@Composable
fun DataUtil(
    value: String,
    label: String,
    resultValue: String,
    resultLabel: String,
    onValueUpdate: (String) -> Unit,
    onFirstDropDownExpanded: (Boolean) -> Unit,
    onFirstDropDownSelectedValue: (String) -> Unit,
    onSecondDropDownExpanded: (Boolean) -> Unit,
    onSecondDropDownSelectedValue: (String) -> Unit
) {
    SimpleInputField(value = value, label = label, onValueUpdate = {
        onValueUpdate(it)
    })
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        SimpleDropDownMenu(selectedValue = "Byte B",
            dropDownItems = listOf(""),
            expanded = false,
            onDropDownExpanded = {
                onFirstDropDownExpanded(it)
            },
            onDropDownSelectedValue = {
                onFirstDropDownSelectedValue(it)
            })

        SimpleDropDownMenu(selectedValue = "Byte B",
            dropDownItems = listOf(""),
            expanded = false,
            onDropDownExpanded = {
                onSecondDropDownExpanded(it)
            },
            onDropDownSelectedValue = {
                onSecondDropDownSelectedValue(it)
            })
    }
    SimpleInputField(value = resultValue, label = resultLabel, onValueUpdate = {})
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun DataUtilPreview() {
    DataScreen(paddingValues = PaddingValues(), viewModel = DataViewModel())
}