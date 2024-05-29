package com.example.navigationsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationsample.ui.theme.FirstScreen
import com.example.navigationsample.ui.theme.NavigationSampleTheme
import com.example.navigationsample.ui.theme.SecondScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationSampleTheme {
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
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "first")
    {
        composable("first"){

            FirstScreen {
                name->
                navController.navigate("second/$name")
            }
        }
        composable("second/{name}")
        {
            val name = it.arguments?.getString("name")?:"no name"

            SecondScreen(name) {
                navController.navigate("first")
            }
        }



    }


}
