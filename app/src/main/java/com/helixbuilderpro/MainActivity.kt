package com.helixbuilderpro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                HelixBuilderScreen()
            }
        }
    }
}


@Composable
fun HelixBuilderScreen() {

    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Text("🌀 HelixBuilderPro")
                }
            )
        }

    ) { padding ->

        Column(

            modifier = Modifier
                .padding(padding)
                .padding(16.dp),

            verticalArrangement = Arrangement.spacedBy(16.dp)

        ) {


            Card(

                modifier = Modifier.fillMaxWidth()

            ) {

                Column(

                    modifier = Modifier.padding(16.dp)

                ) {


                    Text(

                        text = "Helix Antenna 4990 MHz",

                        style = MaterialTheme.typography.titleLarge

                    )


                    Spacer(

                        modifier = Modifier.height(8.dp)

                    )


                    Text("🌀 Количество витков: 12")
                    Text("🔩 Диаметр провода: 1.5 мм")
                    Text("📏 Диаметр спирали: 19.1 мм")
                    Text("↕ Шаг витка: 13.8 мм")

                }
            }



            Button(

                onClick = {},

                modifier = Modifier.fillMaxWidth()

            ) {

                Text("🛠 Мастер сборки")

            }



            Button(

                onClick = {},

                modifier = Modifier.fillMaxWidth()

            ) {

                Text("📐 Калькулятор")

            }



            Button(

                onClick = {},

                modifier = Modifier.fillMaxWidth()

            ) {

                Text("📖 Инструкция")

            }



            Button(

                onClick = {},

                modifier = Modifier.fillMaxWidth()

            ) {

                Text("🖨 3D Печать")

            }

        }
    }
}
