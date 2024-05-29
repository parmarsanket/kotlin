package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    myapp()
                }
            }
        }
    }
}

@Composable
fun myapp()
{
    Box (modifier = Modifier.fillMaxSize()){

        Column (){
            Row (modifier = Modifier.fillMaxHeight(0.5f)){
                Box(modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .fillMaxHeight()
                    .background(Color(0xFFEADDFF))
                    .padding(16.dp)
                    , contentAlignment = Alignment.Center

                ) {
                    Column {
                        Text(text = "Text composable", fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.padding(vertical = 16.dp))
                        Text(text = "Displays text and follows the recommended Material Design guidelines.", textAlign = TextAlign.Justify)
                    }
                    
                }
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(Color(0xFFD0BCFF)
                    ).padding(16.dp)
                    , contentAlignment = Alignment.Center){
                    Column {
                        Text(text = "Image composable", fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.padding(vertical = 16.dp))
                        Text(text = "Creates a composable that lays out and draws a given Painter class object.", textAlign = TextAlign.Justify)
                    }
                }

            }
            Row (modifier = Modifier.fillMaxSize()){
                Box(modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .fillMaxHeight()
                    .background(Color(0xFFB69DF8)).padding(16.dp),
                    contentAlignment = Alignment.Center) {
                    Column {
                        Text(text = "Row composable", fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.padding(vertical = 16.dp))
                        Text(text = "A layout composable that places its children in a horizontal sequence.", textAlign = TextAlign.Justify)
                    }
                }
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(Color(0xFFF6EDFF)).padding(16.dp),
                    contentAlignment = Alignment.Center){
                    Column {
                        Text(text = "Column composable", fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.padding(vertical = 16.dp))
                        Text(text = "A layout composable that places its children in a vertical sequence.", textAlign = TextAlign.Justify)
                    }
                }

            }
        }

    }
}
