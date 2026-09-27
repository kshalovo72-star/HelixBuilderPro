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
            "Подготовьте детали для сборки Helix 4990 MHz.",
            listOf(
                "Медный провод",
                "Разъём SMA",
                "Каркас или шаблон",
                "Инструменты"
            )
        ),

        AssemblyStep(
            "Расчёт параметров",
            "Проверьте размеры перед изготовлением.",
            listOf(
                "Частота 4990 MHz",
                "12 витков",
                "Размеры рассчитаны"
            )
        ),

        AssemblyStep(
            "Намотка спирали",
            "Создайте ровную спиральную форму.",
            listOf(
                "12 витков выполнены",
                "Витки одинаковые",
                "Нет деформации"
            )
        ),

        AssemblyStep(
            "Контроль шага",
            "Проверьте расстояние между витками.",
            listOf(
                "Шаг одинаковый",
                "Спираль ровная"
            )
        ),

        AssemblyStep(
            "Проверка диаметра",
            "Измерьте диаметр готовой спирали.",
            listOf(
                "Диаметр соответствует расчёту",
                "Форма правильная"
            )
        ),

        AssemblyStep(
            "Установка SMA",
            "Установите разъём подключения.",
            listOf(
                "Контакт подготовлен",
                "Крепление выполнено"
            )
        ),

        AssemblyStep(
            "Фиксация",
            "Закрепите конструкцию.",
            listOf(
                "Спираль держится",
                "Нет люфта"
            )
        ),

        AssemblyStep(
            "Проверка геометрии",
            "Контроль всей формы антенны.",
            listOf(
                "Ось ровная",
                "Витки симметричные"
            )
        ),

        AssemblyStep(
            "Подготовка корпуса",
            "Подготовьте детали корпуса.",
            listOf(
                "Модель корпуса готова",
                "Крепления проверены"
            )
        ),

        AssemblyStep(
            "3D печать деталей",
            "Подготовка деталей для печати.",
            listOf(
                "STL файл готов",
                "Размеры проверены",
                "Настройки выбраны"
            )
        ),

        AssemblyStep(
            "Финальная сборка",
            "Соедините все элементы.",
            listOf(
                "Все детали установлены",
                "Проверка выполнена"
            )
        ),

        AssemblyStep(
            "Финальный контроль",
            "Антенна готова к проверке.",
            listOf(
                "Внешний осмотр",
                "Все соединения проверены"
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
            text = "🛠 Мастер сборки Helix",
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
                    modifier = Modifier.height(8.dp)
                )


                Text(
                    steps[step].description
                )


                Spacer(
                    modifier = Modifier.height(8.dp)
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

                    if(step > 0) step--

                }
            ){

                Text("⬅ Назад")

            }



            Button(
                onClick = {

                    if(step < steps.size - 1) step++

                }
            ){

                Text("Далее ➡")

            }

        }

    }

}
