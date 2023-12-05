package com.example.radiobutton

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RadioSpinnerDemo() {

    var selectedCountry by remember { mutableStateOf<String?>("") }
    var selectedCity by remember { mutableStateOf<String?>("") }

    val countries = listOf("USA", "Canada", "Mexico")
    val cities = when(selectedCountry) {
        "USA" -> listOf("New York", "Los Angeles", "Chicago","Atlanta", "Washington DC")
        "Canada" -> listOf("Toronto", "Vancouver", "Montreal", "Calgary", "Ottawa", "Winipeg")
        "Mexico" -> listOf("Mexico City", "Guadalajara", "Monterrey", "Santiago de Querétaro", "San Miguel de Allende")
        else -> emptyList()
    }

    Column {
        countries.forEach { country ->
            Row(Modifier.padding(8.dp)) {
                RadioButton(selected = (country == selectedCountry),
                    onClick = { selectedCountry = country })

                Text(text = country)
            }
        }

        Spinner(cities) {
            selectedCity = it
        }

        Button(onClick = {}) {
            Text("Submit")
        }

        Text("You Selected: $selectedCountry, $selectedCity")
    }
}


@Preview
@Composable
fun RadioSpinnerDemoPreview(){
    RadioSpinnerDemo()
}