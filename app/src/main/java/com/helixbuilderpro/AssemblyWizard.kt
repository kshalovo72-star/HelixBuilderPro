package com.helixbuilderpro

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun AssemblyWizard() {

    var step by remember { mutableStateOf(1) }

    val steps = listOf(
        "Подготовка материалов",
        "Проверка размеров",
        "Намотка спирали",
        "Контроль шага витка",
        "Проверка диаметра",
        "Установка SMA разъёма",
        "Фиксация спирали",
        "Проверка геометрии",
        "Подготовка корпуса",
        "3D печать деталей",
        "Финальная сборка",
        "Проверка готовой антенны"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Text(
            text = "🛠 Мастер сборки Helix",
            style = MaterialTheme.typography.headlineSmall
        )

        Text(
            text = "Шаг $step из 12"
        )

        Card {

            Text(
                text = steps[step - 1],
                modifier = Modifier.padding(20.dp)
            )

        }


        Button(
            onClick = {
                if (step < 12) {
                    step++
                }
            },

            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Далее")
        }


        Button(
            onClick = {
                if (step > 1) {
                    step--
                }
            },

            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Назад")
        }
    }
}
