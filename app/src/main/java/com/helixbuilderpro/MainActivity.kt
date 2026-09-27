
    package com.helixbuilderpro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            MaterialTheme {

                HelixBuilderApp()

            }

        }
    }
}


@Composable
fun HelixBuilderApp() {

    var screen by remember {
        mutableStateOf("home")
    }


    when(screen) {


        "assembly" -> {

            AssemblyWizard()

        }


        "calculator" -> {

            Calculator()

        }


        "3d" -> {

            Helix3DViewer()

        }


        "printer" -> {

            PrinterGuide()

        }


        else -> {


            Column(

                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),

                verticalArrangement = Arrangement.spacedBy(18.dp)

            ) {


                Text(

                    text = "🌀 Helix Builder Pro",

                    style = MaterialTheme.typography.headlineMedium

                )


                Text(

                    text = "Антенна Helix 4990 MHz\n12 витков"

                )


                Button(

                    onClick = {

                        screen = "assembly"

                    },

                    modifier = Modifier.fillMaxWidth()

                ){

                    Text("🛠 Мастер сборки")

                }



                Button(

                    onClick = {

                        screen = "calculator"

                    },

                    modifier = Modifier.fillMaxWidth()

                ){

                    Text("📐 Калькулятор")

                }



                Button(

                    onClick = {

                        screen = "3d"

                    },

                    modifier = Modifier.fillMaxWidth()

                ){

                    Text("🌀 3D модель")

                }



                Button(

                    onClick = {

                        screen = "printer"

                    },

                    modifier = Modifier.fillMaxWidth()

                ){

                    Text("🖨 3D печать")

                }


            }

        }

    }

}


            


                    
        
    

