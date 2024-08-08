package com.example.t1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.t1.ui.theme.T1Theme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            T1Theme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                 ) {
                    Greeting(
                        name = "Android" ,
                        modifier = Modifier
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(name : String , modifier : Modifier = Modifier) {
          //  TopAppBar(title = { Text(text = "sanket") }, colors = TopAppBarDefaults
             //   .smallTopAppBarColors(containerColor = Color.Blue ), modifier = modifier)

        Column (modifier = Modifier.fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()){
              TopAppBar(title = { Text(text = "sanket") }, colors = TopAppBarDefaults
               .smallTopAppBarColors(containerColor = Color.Blue ), modifier = modifier)

        }



    }



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    T1Theme {
        Greeting("Android")
    }
}