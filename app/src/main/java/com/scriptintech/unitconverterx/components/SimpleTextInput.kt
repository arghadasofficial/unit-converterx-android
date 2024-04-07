package com.scriptintech.unitconverterx.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun SimpleInputField(
    value: String,
    label: String,
    onValueUpdate: (String) -> Unit,
    keyboardOption: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
) {
    OutlinedTextField(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp),
        keyboardOptions = keyboardOption,
        label = { Text(text = label) },
        value = value,
        onValueChange = { onValueUpdate(it) })
}