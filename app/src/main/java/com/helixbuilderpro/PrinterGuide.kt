package com.helixbuilderpro

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun PrinterGuide() {

    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

        verticalArrangement = Arrangement.spacedBy(16.dp)

    ) {


        Text(
            text = "🖨 3D печать Helix",
            style = MaterialTheme.typography.headlineSmall
        )


        Card {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text("Детали для печати:")

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text("✅ Корпус антенны")
                Text("✅ Держатель спирали")
                Text("✅ Крепление SMA")
                Text("✅ Защитный кожух")

            }

        }


        Card {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text("⚙ Настройки печати:")

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text("• Слой: 0.2 мм")
                Text("• Заполнение: 30%")
                Text("• Материал: PETG / PLA")
                Text("• Формат модели: STL")

            }

        }


        Card {

            Text(

                text = "📦 STL библиотека будет добавлена",

                modifier = Modifier.padding(16.dp)

            )

        }

    }

}
