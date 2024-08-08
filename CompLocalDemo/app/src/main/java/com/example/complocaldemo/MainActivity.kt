package com.example.complocaldemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.complocaldemo.ui.theme.CompLocalDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompLocalDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize() ,
                    color = MaterialTheme.colorScheme.background
                ) {

                    Composable1()

                }
            }
        }
    }
}
val LocalColor = staticCompositionLocalOf { Color(0xFFffdbcf) }
@Composable
fun Composable1() {
    val color = if (isSystemInDarkTheme()) {
        Color(0xFFa08d87)
    } else {
        Color(0xFFffdbcf)
    }


        Column {
            Composable2()
            CompositionLocalProvider(LocalColor provides color)
            {
                Composable3()
            }
        }

}

@Composable
fun Composable2() {
    Composable4()
}
@Composable
fun Composable3() {
    Composable5()
}

@Composable
fun Composable4() {
    Composable6()
}

@Composable
fun Composable5() {
    Composable7()
    Composable8()
}

@Composable
fun Composable6() {
    Text("Composable 6")
}

@Composable
fun Composable7() {
  
}

@Composable
fun Composable8() {
    Text("Composable 8", modifier = Modifier.background(LocalColor.current))
}
