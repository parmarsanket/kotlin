package com.example.ebookstest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ebookstest.ui.theme.EbookstestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EbookstestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    DemoScreen()
                }
            }
        }
    }
}

@Composable
fun DemoText(message: String, fontSize: Float) {

    Text(
        text = message,
        fontSize = fontSize.sp,
        fontWeight = FontWeight.Bold
    )

}

@Composable
fun DemoScreen() {

    var sliderPosition by remember { mutableStateOf(23f) }

    val handlePositionChange = { position: Float ->
        sliderPosition = position
    }
    DemoSlider(
        sliderPosition = sliderPosition, onPositionChange = handlePositionChange
    )
}

@Composable
fun DemoSlider(
    sliderPosition: Float, onPositionChange: (Float) -> Unit
) {
    Slider(modifier = Modifier.padding(20.dp),
        valueRange = 23f..37f, value = sliderPosition,
        onValueChange = {
            onPositionChange(it)
        }
    )
}

@Preview(showSystemUi = true)
@Composable
fun view() {
    DemoScreen()
}
