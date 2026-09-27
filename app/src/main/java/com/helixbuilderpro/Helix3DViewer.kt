package com.helixbuilderpro

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import kotlin.math.cos
import kotlin.math.sin


@Composable
fun Helix3DViewer() {

    var rotation by remember {
        mutableStateOf(0f)
    }


    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

        verticalArrangement = Arrangement.spacedBy(16.dp)

    ) {


        Text(

            text = "🌀 3D модель Helix 4990",

            style = MaterialTheme.typography.headlineSmall

        )


        Text(
            text = "12 витков • интерактивный просмотр"
        )


        Canvas(

            modifier = Modifier

                .fillMaxWidth()
                .height(350.dp)

                .pointerInput(Unit) {

                    detectDragGestures { change, drag ->

                        change.consume()

                        rotation += drag.x

                    }

                }

        ) {


            val center = Offset(
                size.width / 2,
                size.height / 2
            )


            var lastPoint = center


            for(i in 0 until 240) {


                val angle =
                    i * 0.25 + rotation / 50


                val radius =
                    20 + i * 0.7


                val x =
                    center.x + cos(angle) * radius


                val y =
                    center.y + sin(angle) * radius / 3


                drawLine(

                    start = lastPoint,

                    end = Offset(
                        x.toFloat(),
                        y.toFloat()
                    ),

                    strokeWidth = 5f

                )


                lastPoint =
                    Offset(
                        x.toFloat(),
                        y.toFloat()
                    )

            }

        }


        Card {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text("Параметры модели:")

                Text("🌀 Витков: 12")

                Text("📡 Частота: 4990 MHz")

                Text("🖨 Экспорт STL: подготовка")

            }

        }

    }

}
