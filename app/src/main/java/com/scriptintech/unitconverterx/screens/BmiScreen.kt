package com.scriptintech.unitconverterx.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.scriptintech.unitconverterx.viewmodels.BmiViewModel

@Composable
fun BmiScreen(context: Context, viewModel: BmiViewModel, paddingValues: PaddingValues) {
    val heightInput by viewModel.heightInput.observeAsState(initial = "")
    val weightInput by viewModel.weightInput.observeAsState(initial = "")
    val bmiResult by viewModel.bmiResult.observeAsState(initial = "")
    val bmiResultType by viewModel.bmiResultType.observeAsState(initial = "")

    Column (modifier = Modifier.fillMaxSize().padding(paddingValues)) {
        BmiInput(
            heightInput = heightInput,
            weightInput = weightInput,
            onHeightChange = { viewModel.changeHeightInput(it) },
            onWeightChange = { viewModel.changeWeightInput(it) },
            onCalculateButtonClick = {
                viewModel.calculateBmi()
            })
        BmiResult(bmiResult = bmiResult, bmiResultType = bmiResultType, onResultClick = {
            Toast.makeText(context, "onResultClick()", Toast.LENGTH_LONG).show()
        })
    }
}

@Composable
private fun BmiInput(
    heightInput: String,
    weightInput: String,
    onHeightChange: (String) -> Unit,
    onWeightChange: (String) -> Unit,
    onCalculateButtonClick: () -> Unit
) {
    Column {
        // Height Input Field OutlinedTextField
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            placeholder = { Text(text = "Enter Height") },
            label = { Text(text = "Height (cm)") },
            value = heightInput, onValueChange = { onHeightChange(it) })

        // Weight Input Field OutlinedTextField
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            placeholder = { Text(text = "Enter Weight") },
            label = { Text(text = "Weight (kg)") },
            value = weightInput, onValueChange = { onWeightChange(it) })

        // Calculate Button FilledIconButton
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            onClick = { onCalculateButtonClick() }) {
            Text(text = "Calculate")
        }
    }
}

@Composable
private fun BmiResult(
    bmiResult: String,
    bmiResultType: String,
    onResultClick: () -> Unit
) {

    Column {
        // BMI Result Text
        Text(
            text = bmiResult,
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp)
        )
        if (bmiResultType.isNotEmpty()) {
            Text(
                text = "Body mass index",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, top = 0.dp)
            )
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Green,
                    contentColor = Color.Black
                ),
                modifier = Modifier
                    .wrapContentSize()
                    .padding(start = 8.dp, top = 8.dp),
                onClick = { onResultClick() }) {
                Text(text = bmiResultType)
            }
        }
    }
}