
            package com.helixbuilderpro

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


data class AssemblyStep(
    val title: String,
    val description: String,
    val checks: List<String>
)


@Composable
fun AssemblyWizard() {

    var step by remember { mutableStateOf(0) }


    val steps = listOf(

        AssemblyStep(
            "Подготовка материалов",
            "Подготовьте всё необходимое для сборки Helix 4990 MHz.",
            listOf(
                "Медный провод 1.5 мм",
                "Инструмент для намотки",
                "Разъём SMA",
                "Измерительный инструмент"
            )
        ),

        AssemblyStep(
            "Расчёт размеров",
            "Проверьте размеры антенны перед изготовлением.",
            listOf(
                "Количество витков: 12",
                "Диаметр спирали проверен",
                "Шаг витка рассчитан"
            )
        ),

        AssemblyStep(
            "Намотка спирали",
            "Аккуратно выполните намотку 12 витков.",
            listOf(
                "Витки ровные",
                "Расстояние одинаковое",
                "Нет деформации"
            )
        )

    )


    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

        verticalArrangement = Arrangement.spacedBy(16.dp)

    ) {


        Text(
            text = "🌀 Сборка Helix 4990",
            style = MaterialTheme.typography.headlineSmall
        )


        Text(
            text = "Шаг ${step + 1} из ${steps.size}"
        )


        LinearProgressIndicator(
            progress = (step + 1).toFloat() / steps.size,
            modifier = Modifier.fillMaxWidth()
        )


        Card {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {


                Text(
                    text = steps[step].title,
                    style = MaterialTheme.typography.titleLarge
                )


                Spacer(
                    modifier = Modifier.height(10.dp)
                )


                Text(
                    text = steps[step].description
                )


                Spacer(
                    modifier = Modifier.height(10.dp)
                )


                steps[step].checks.forEach {

                    Text("☑ $it")

                }

            }

        }



        Row(

            modifier = Modifier.fillMaxWidth(),

            horizontalArrangement = Arrangement.SpaceBetween

        ) {


            Button(

                onClick = {

                    if (step > 0) step--

                }

            ) {

                Text("⬅ Назад")

            }



            Button(

                onClick = {

                    if (step < steps.size - 1) step++

                }

            ) {

                Text("Далее ➡")

            }

        }

    }

}
