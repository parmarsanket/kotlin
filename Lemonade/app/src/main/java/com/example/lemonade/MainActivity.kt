package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    lemon(
                        Modifier
                            .fillMaxSize()
                            .wrapContentSize(Alignment.Center))
                }
            }
        }
    }
}

@Composable
fun lemon(modifier: Modifier)
{
    Column (modifier = modifier
        ,
        horizontalAlignment = Alignment.CenterHorizontally) {
        val img = remember { mutableStateOf(R.drawable.lemon_tree) }
        val txt = remember { mutableStateOf("Tap the lemon tree to select a lemon") }
        val list = listOf(
            R.drawable.lemon_tree to "Tap the lemon tree to select a lemon",
            R.drawable.lemon_squeeze to "Keep tapping the lemon to squeeze it",
            R.drawable.lemon_drink to "Tap the lemonade to drink it",
            R.drawable.lemon_restart to "Tap the empty glass to start again"
        )
        var number by remember {
            mutableStateOf(0)
        }
        Card(shape = RoundedCornerShape(15)) {


            Image(
                painter = painterResource(id = img.value), contentDescription = null,
                modifier = Modifier
                    .size(300.dp)
                    .clickable {
                        number++
                        if (number == list.size )
                        {
                            number = 0
                        }
                        img.value = list[number].first
                        txt.value = list[number].second

                    }
            )
        }
        Spacer(modifier = Modifier.padding(8.dp))
        Text(text = txt.value, fontSize = 20.sp, textAlign = TextAlign.Justify)
    }
}

    
