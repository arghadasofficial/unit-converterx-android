package com.scriptintech.unitconverterx.components

import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.scriptintech.unitconverterx.components.model.UnitDropdownModel

@Composable
fun UDropdown(
    items: List<UnitDropdownModel>,
    expanded: Boolean = false,
    onDismiss: () -> Unit,
    onItemClick: (String) -> Unit
) {

    DropdownMenu(expanded = expanded, onDismissRequest = { onDismiss() }) {
        items.forEach { item ->
            DropdownMenuItem(text = { Text(text = item.text) }, onClick = { onItemClick(item.key) })
        }
    }
}
