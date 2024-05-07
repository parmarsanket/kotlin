package com.example.unitconveter


import android.os.Bundle

import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.VectorConverter
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unitconveter.ui.theme.UnitConveterTheme
import java.util.logging.Handler
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConveterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    unitconveter()
                }
            }
        }
    }
}



@Composable
fun unitconveter()
{
    var inputvalue by remember { mutableStateOf("") }
    var outputvalue by remember { mutableStateOf("") }
    var inputunit by remember { mutableStateOf("Select") }
    var outputunit by remember { mutableStateOf("Select") }
    var conversionfacter by remember {mutableStateOf(1.00)}
    var oconversionfacter by remember {mutableStateOf(1.00)}
    var iExpanted by remember{mutableStateOf(false)}
    var oExpanted by remember{mutableStateOf(false)}

     fun convterunit()
     {
         val inputvaluedouble=inputvalue.toDoubleOrNull()?:0.0
         val result = (inputvaluedouble*conversionfacter*100.0/oconversionfacter)/100

         outputvalue=result.toFloat().toString()
     }
    Column(
   modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

            )
    {
        //stack here Greeting("Android")
        Text(text = "Unit Converter", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = inputvalue, onValueChange = {/*here goes what should
         happed when the value of outline change*/
            inputvalue = it
            convterunit()
        }, label = { Text(text = "Enter the value") })
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            //inputbox
            Box {
                //inputbutton
                Button(
                    onClick = { iExpanted = true },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
                ) {

                    Text(text = inputunit)
                    // Icon(Icons.Default.ArrowDropDown,)
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = ""
                    )
                }
                DropdownMenu(expanded = iExpanted, onDismissRequest = { iExpanted = false }) {
                    DropdownMenuItem(text = { Text(text = "Centimeters") }, onClick = {
                        android.os.Handler().postDelayed({
                            iExpanted = false
                        }, 120)
                        inputunit = "Centimeters"
                        conversionfacter = 0.01
                        convterunit()

                    })
                    DropdownMenuItem(text = { Text(text = "Meters") }, onClick = {
                        android.os.Handler().postDelayed({
                            iExpanted = false
                        }, 120)
                        inputunit = "Meters"
                        conversionfacter = 1.0
                        convterunit()
                    })
                    DropdownMenuItem(text = { Text(text = "Feet's") }, onClick = {
                        android.os.Handler().postDelayed({
                            iExpanted = false
                        }, 120)
                        inputunit = "Feet's"
                        conversionfacter = 0.3048
                        convterunit()
                    })
                    DropdownMenuItem(text = { Text(text = "Millimeters") }, onClick = {
                        android.os.Handler().postDelayed({
                            iExpanted = false
                        }, 120)
                        inputunit = "Millimeters"
                        conversionfacter = 0.001
                        convterunit()
                    })
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            //outputbox
            Box {
                Button(
                    onClick = { oExpanted = true },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
                )
                {

                    Text(text = outputunit)
                    // Icon(Icons.Default.ArrowDropDown,)
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = ""
                    )
                }
                DropdownMenu(expanded = oExpanted, onDismissRequest = { oExpanted = false }) {
                    DropdownMenuItem(text = { Text(text = "Centimeters") }, onClick = {
                        android.os.Handler().postDelayed({
                            oExpanted = false
                        }, 120)
                        outputunit = "Centimeters"
                        oconversionfacter = 0.010
                        convterunit()
                    })
                    DropdownMenuItem(text = { Text(text = "Meters") }, onClick = {
                        android.os.Handler().postDelayed({
                            oExpanted = false
                        }, 120)
                        outputunit = "Meters"
                        oconversionfacter = 1.00
                        convterunit()
                    })
                    DropdownMenuItem(text = { Text(text = "Feet's") }, onClick = {
                        android.os.Handler().postDelayed({
                            oExpanted = false
                        }, 120)
                        outputunit = "Feet's"
                        oconversionfacter = 0.3048
                        convterunit()
                    })
                    DropdownMenuItem(text = { Text(text = "Millimeters") }, onClick = {
                        android.os.Handler().postDelayed({
                            oExpanted = false
                        }, 120)
                        outputunit = "Millimeters"
                        oconversionfacter = 0.001
                        convterunit()
                    })
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Result $outputvalue  $outputunit",
            style = MaterialTheme.typography.headlineMedium
        )
    }
}
@Preview(showBackground = true)
@Composable
fun UnitconveterPreview()
{
    unitconveter()
}