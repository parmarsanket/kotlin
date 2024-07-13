package com.example.practicebuildagrid

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.practicebuildagrid.ui.theme.AppTheme
//import com.example.practicebuildagrid.ui.theme.PracticeBuildAGridTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(


                    modifier = Modifier
                        .fillMaxSize()
                        .padding(0.dp),
                ) {
                   App()
                }
            }
        }
    }
}
@Composable
fun App()
{
    val check = remember {
        mutableStateOf(false)
    }
    val int = remember {
        mutableStateOf(2)
    }
    val configuration = LocalConfiguration.current

    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            if (check.value)
            {int.value=3}
            else
            {
                int.value=1
            }
        }
        else -> {
            if (check.value)
            {int.value=2}
            else
            {
                int.value=1
            }
        }
    }
    Column (modifier = Modifier.padding(8.dp)){
        Card() {


            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
            ) {
                Text(text = "Switch", fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.padding(16.dp))

                Switch(checked = check.value, onCheckedChange = { check.value = it }
                )
            }
        }

        Spacer(modifier = Modifier.padding(8.dp))


        LazyVerticalGrid(
            columns = GridCells.Fixed(int.value),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),

            ) {
            items(DataSource.topics) { sk ->
                listBody(sk)
            }
        }
    }

}

