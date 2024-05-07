package com.example.captangame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.captangame.ui.theme.CaptanGameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaptanGameTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    capGame()
                }
            }
        }
    }
}

@Composable
fun capGame()
{

    Text(text = "Captan Game")

    val treasuresFound = remember{mutableStateOf(0)  }
    val direction = remember {
        mutableStateOf("North")
    }
    val shipdamage =  remember{mutableStateOf(0)  }
    Column {
        Text(text = "Captan Game")
        Text(text = "treasuresFound = ${treasuresFound.value}")
        Text(text = "current direction= ${direction.value}")
        Text(text = "Strome ship damage = ${shipdamage.value}")
        if(shipdamage.value<=10) {
            Button(onClick = {
                direction.value = "East"
                if (Random.nextBoolean()) {
                    treasuresFound.value += 1
                    if (Random.nextBoolean())
                        shipdamage.value += 1
                }

            })
            {
                Text(text = "Sail East")
            }
            Button(onClick = {
                direction.value = "West"
                if (Random.nextBoolean()) {
                    treasuresFound.value += 1
                    if (Random.nextBoolean())
                        shipdamage.value += 1
                }

            })
            {
                Text(text = "Sail West")
            }
            Button(onClick = {
                direction.value = "North"
                if (Random.nextBoolean()) {
                    treasuresFound.value += 1
                    if (Random.nextBoolean())
                        shipdamage.value += 1
                }

            })
            {
                Text(text = "Sail North")
            }
            Button(onClick = {
                direction.value = "South"
                if (Random.nextBoolean()) {
                    treasuresFound.value += 1
                    if (Random.nextBoolean())
                        shipdamage.value += 1
                }

            })
            {
                Text(text = "Sail South")

            }
        }
        else
        {
            Text(text = "Captan game over")
            Text(text = "Total treasure point = ${treasuresFound.value}")
            Button(onClick = {
                direction.value = "North"
                treasuresFound.value=0
               shipdamage.value=0

            })
            {
                Text(text = "Restart game")
            }

        }



    }


    
}

