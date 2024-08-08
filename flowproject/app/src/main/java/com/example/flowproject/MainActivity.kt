package com.example.flowproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.flowproject.ui.theme.FlowprojectTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlowprojectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize() ,
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MainScreen() {
    val items = (1 .. 16).map {
        ItemProperties(
            width = Random.nextInt(20, 100).dp,
            height = Random.nextInt(20, 100).dp,
            color = Color(
                Random.nextInt(255),
                Random.nextInt(255),
                Random.nextInt(255),
                255
            )
        )
    }
    FlowColumn(Modifier.width(300.dp).
    padding(8.dp)
        , horizontalArrangement = Arrangement.Start
        , verticalArrangement = Arrangement.SpaceAround
    ) {

        items.forEach { properties ->
            Box(
                modifier = Modifier
                    .padding(2.dp)
                    .width(properties.width)
                    .height(properties.height)
                    .clip(RoundedCornerShape(8.dp))
                    .background(properties.color)
            )
        }
    }

}
@Composable
@Preview (showBackground = true)
fun PreviewMainScreen() {
    FlowprojectTheme {
        MainScreen()
    }
}