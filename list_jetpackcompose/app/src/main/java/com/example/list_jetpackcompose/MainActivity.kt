package com.example.list_jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.list_jetpackcompose.ui.theme.List_jetpackcomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            List_jetpackcomposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                )
                {

                   /*Column (
                       modifier = Modifier.verticalScroll(ScrollState(0),enabled = true, flingBehavior =null)
                   )
                   {
                       for (i in 1..50)
                       {
                           Text(text = "item"+i,
                               fontSize = 24.sp
                               , fontWeight = FontWeight.Bold
                               , textAlign = TextAlign.Center
                               , modifier = Modifier.fillMaxWidth()
                                   .padding(vertical = 24.dp)
                           )


                       }

                    */
                    LazyColumn{
                        items(10000){
                            Text(text = "item"+it,
                                fontSize = 24.sp
                                , fontWeight = FontWeight.Bold
                                , textAlign = TextAlign.Center
                                , modifier = Modifier.fillMaxWidth()
                                    .padding(vertical = 24.dp)
                            )
                        }
                    }

                }
            }
        }
    }
}


