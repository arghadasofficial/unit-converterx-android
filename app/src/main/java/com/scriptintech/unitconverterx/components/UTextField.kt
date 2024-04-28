package com.scriptintech.unitconverterx.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun UTextField(
    value: String, label: String, onValueChange: (String) -> Unit
) {
    OutlinedTextField(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp),
        value = value,
        label = { Text(text = label) },
        onValueChange = {
            onValueChange(it)
        })
}