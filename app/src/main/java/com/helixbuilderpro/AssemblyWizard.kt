
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
        "Подготовьте все детали для изготовления антенны Helix 4990 MHz.",
        listOf(
            "Медный провод 1.5 мм",
            "Разъём SMA",
            "Инструменты для намотки",
            "Измерительный инструмент"
        )
    ),

    AssemblyStep(
        "Расчёт размеров",
        "Проверьте основные параметры перед изготовлением.",
        listOf(
            "Частота: 4990 MHz",
            "Количество витков: 12",
            "Диаметр проверен"
        )
    ),

    AssemblyStep(
        "Намотка спирали",
        "Изготовьте спираль из провода, соблюдая форму.",
        listOf(
            "12 витков выполнены",
            "Витки ровные",
            "Нет повреждений провода"
        )
    ),

    AssemblyStep(
        "Контроль шага витка",
        "Проверьте расстояние между витками.",
        listOf(
            "Шаг одинаковый",
            "Спираль без перекосов"
        )
    ),

    AssemblyStep(
        "Проверка диаметра",
        "Измерьте внешний размер спирали.",
        listOf(
            "Диаметр соответствует расчёту",
            "Форма круглая"
        )
    ),

    AssemblyStep(
        "Установка SMA разъёма",
        "Подготовьте и установите точку подключения.",
        listOf(
            "Контакт очищен",
            "Соединение закреплено"
        )
    ),

    AssemblyStep(
        "Фиксация спирали",
        "Закрепите конструкцию для сохранения формы.",
        listOf(
            "Спираль держится ровно",
            "Нет люфта"
        )
    ),

    AssemblyStep(
        "Проверка геометрии",
        "Контроль правильности всей конструкции.",
        listOf(
            "Ось ровная",
            "Витки симметричные"
        )
    ),

    AssemblyStep(
        "Подготовка корпуса",
        "Подготовьте детали корпуса для установки.",
        listOf(
            "3D детали готовы",
            "Крепления проверены"
        )
    ),

    AssemblyStep(
        "3D печать деталей",
        "Подготовьте модели для печати.",
        listOf(
            "Модель загружена",
            "Размеры проверены",
            "Настройки печати выбраны"
        )
    ),

    AssemblyStep(
        "Финальная сборка",
        "Соедините все элементы антенны.",
        listOf(
            "Все детали установлены",
            "Крепления затянуты"
        )
    ),

    AssemblyStep(
        "Проверка готовой антенны",
        "Финальный контроль перед использованием.",
        listOf(
            "Внешний осмотр выполнен",
            "Конструкция готова"
        )
    )

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
