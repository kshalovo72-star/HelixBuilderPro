

package com.helixbuilderpro

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun Calculator() {

    var frequency by remember { mutableStateOf("4990") }
    var turns by remember { mutableStateOf("12") }
    var wire by remember { mutableStateOf("1.5") }

    var result by remember { mutableStateOf("") }


    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

        verticalArrangement = Arrangement.spacedBy(14.dp)

    ) {


        Text(
            text = "📐 Helix Calculator",
            style = MaterialTheme.typography.headlineSmall
        )


        OutlinedTextField(
            value = frequency,
            onValueChange = { frequency = it },
            label = { Text("Частота MHz") }
        )


        OutlinedTextField(
            value = turns,
            onValueChange = { turns = it },
            label = { Text("Количество витков") }
        )


        OutlinedTextField(
            value = wire,
            onValueChange = { wire = it },
            label = { Text("Диаметр провода мм") }
        )


        Button(

            onClick = {

                val f = frequency.toDoubleOrNull() ?: 4990.0
                val t = turns.toDoubleOrNull() ?: 12.0

                val wavelength = 300000000 / (f * 1000000)

                val diameter = wavelength / 3.14

                val step = wavelength / (t * 2)


                result =
                    """
                    Расчёт готов:

                    🌀 Витков: ${t.toInt()}

                    📡 Длина волны:
                    ${"%.3f".format(wavelength)} м

                    📏 Расчётный шаг:
                    ${"%.2f".format(step * 1000)} мм

                    📐 Диаметр:
                    ${"%.2f".format(diameter * 1000)} мм
                    """.trimIndent()

            },

            modifier = Modifier.fillMaxWidth()

        ) {

            Text("Рассчитать 🧮")

        }


        Card {

            Text(

                text = result,

                modifier = Modifier.padding(16.dp)

            )

        }

    }
}
