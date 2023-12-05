package com.example.radiobutton

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Spinner(options: List<String>, onSelected: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf(options.firstOrNull() ?: "") }

    Box {
        Text(text = selectedOptionText)

        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            options.forEach { selectionOption ->
                DropdownMenuItem(onClick = {
                    selectedOptionText = selectionOption
                    expanded = false
                    onSelected(selectionOption)
                }){
                    Text(text = selectionOption)
                }
            }
        }
    }
}

fun DropdownMenuItem(onClick: () -> Unit, interactionSource: () -> Unit) {

}

@Preview
@Composable
fun SpinnerPreview() {
    Spinner(listOf("Option 1", "Option 2")) {}
}