package com.scriptintech.unitconverterx.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun UTriggerButton(
    value: String = "Trigger", onClick: () -> Unit = {}
) {
    Button(
        onClick = { onClick() }, contentPadding = ButtonDefaults.ButtonWithIconContentPadding
    ) {
        Icon(
            Icons.Filled.ArrowDropDown,
            contentDescription = "",
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text(text = value)
    }
}

@Composable
fun UButton(
    modifier: Modifier = Modifier, value: String = "Trigger", onClick: () -> Unit = {}
) {
    Button(
        modifier = modifier,
        onClick = { onClick() },
        contentPadding = ButtonDefaults.ButtonWithIconContentPadding
    ) {
        Text(text = value)
    }
}