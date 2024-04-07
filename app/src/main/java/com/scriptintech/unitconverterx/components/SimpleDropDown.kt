package com.scriptintech.unitconverterx.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun SimpleDropDownMenu(
    selectedValue: String,
    dropDownItems: List<String>,
    expanded: Boolean,
    onDropDownExpanded: (Boolean) -> Unit,
    onDropDownSelectedValue: (String) -> Unit
) {
    Column {
        OutlinedButton(onClick = { onDropDownExpanded(true) }) {
            Text(text = selectedValue)
            Icon(Icons.Default.ArrowDropDown, contentDescription = null)
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { onDropDownExpanded(false) }) {
            dropDownItems.forEach {
                DropdownMenuItem(text = { Text(text = it) }, onClick = {
                    onDropDownExpanded(false)
                    onDropDownSelectedValue(it)
                })
            }
        }
    }
}