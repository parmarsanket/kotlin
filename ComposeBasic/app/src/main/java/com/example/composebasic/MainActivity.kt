package com.example.composebasic

import android.graphics.Paint.Align
import android.os.Bundle
import android.provider.CalendarContract.Colors
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composebasic.ui.theme.ComposeBasicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Composebasic()
                }
            }
        }
    }
}

@Composable
fun Composebasic() {
    val img = painterResource(id = R.drawable.bg_compose_background)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp)
    ) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp),
            shape = RoundedCornerShape(20.dp)
        ) {
            Image(
                painter = img,
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
        }
        Spacer(modifier = Modifier.padding(vertical = 8.dp))

        Text(text = "Jetpack Compose tutorial", fontSize = 24.sp, textAlign = TextAlign.Justify)

        Spacer(modifier = Modifier.padding(vertical = 16.dp))
        Text(text = "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and " +
                "accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.", textAlign = TextAlign.Justify)
     Spacer (modifier = Modifier.padding(vertical = 16.dp))
        Text(text = "In this tutorial, you build a simple UI component with declarative functions. " +
                "You call Compose functions to say what elements you want and the Compose compiler does" +
                " the rest. Compose is built around Composable functions. These functions let you define your app\\'s" +
                " UI programmatically because they let you describe how it should look and provide data dependencies, " +
                "rather than focus on the process of the UI\\'s construction, such as initializing an element and then attaching" +
                " it to a parent. To create a Composable function, you add the @Composable annotation to the function name.", textAlign = TextAlign.Justify)
    }

}