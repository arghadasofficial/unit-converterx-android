package com.scriptintech.unitconverterx.screens.unitscreens.time

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimeScreen(navController: NavController, viewModel: TimeViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Time") },
                navigationIcon = {
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
    viewModel: TimeViewModel
) {
    Column(modifier = Modifier.padding(paddingValues)) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            value = viewModel.inputTime.value,
            label = { Text(text = viewModel.inputLabel.value) },
            onValueChange = {
                viewModel.changeInputTime(it)
                viewModel.calculate()
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            trailingIcon = {
                IconButton(onClick = { viewModel.changeIsSelectorExpanded(true) }) {
                    Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = "")
                }
            }
        )
        DropdownMenu(
            modifier = Modifier.fillMaxWidth(),
            expanded = viewModel.isSelectorExpanded.value,
            onDismissRequest = { viewModel.changeIsSelectorExpanded(false) }) {
            viewModel.dropdownOptions.value.forEach {
                DropdownMenuItem(text = { Text(text = it.name) }, onClick = {
                    viewModel.changeDropdownSelectedOption(it.key)
                    viewModel.changeInputLabel(it.name)
                    viewModel.changeIsSelectorExpanded(false)
                    viewModel.calculate()
                })
            }
        }

        if (viewModel.unitResult.value.data.isNotEmpty()) {

            LazyColumn (modifier = Modifier.padding(8.dp)) {
                items(viewModel.unitResult.value.data.size) {
                    Text(text = viewModel.unitResult.value.data[it].title)
                    Text(text = viewModel.unitResult.value.data[it].value)
                }
            }

        }
    }
}

