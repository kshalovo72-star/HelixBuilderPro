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
    var diameter by remember { mutableStateOf("30") }

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


        Text(
            text = "Расчёт параметров Helix 4990 MHz"
        )


        OutlinedTextField(
            value = frequency,
            onValueChange = { frequency = it },
            label = {
                Text("Частота MHz")
            }
        )


        OutlinedTextField(
            value = turns,
            onValueChange = { turns = it },
            label = {
                Text("Количество витков")
            }
        )


        OutlinedTextField(
            value = diameter,
            onValueChange = { diameter = it },
            label = {
                Text("Диаметр спирали мм")
            }
        )


        Button(

            onClick = {


                val f = frequency.toDoubleOrNull() ?: 4990.0
                val t = turns.toDoubleOrNull() ?: 12.0
                val d = diameter.toDoubleOrNull() ?: 30.0


                val wavelength = 300.0 / f

                val step = wavelength * 1000 / t

                val wireLength =
                    kotlin.math.PI * d * t / 1000


                result = """

                🌀 Результат:

                Частота:
                $f MHz

                Витков:
                ${t.toInt()}

                Шаг витка:
                ${"%.2f".format(step)} мм

                Длина провода:
                ${"%.2f".format(wireLength)} м

                Диаметр:
                ${d.toInt()} мм

                """.trimIndent()

            },

            modifier = Modifier.fillMaxWidth()

        ){

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
