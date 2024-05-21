package com.example.myapplication

import android.accounts.AuthenticatorDescription
import android.icu.text.CaseMap.Title
import android.os.Bundle
import android.view.RoundedCorner
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val painter= painterResource(id = R.drawable.img)
                    val  description="my img      my img "
                    val title ="Anime girl"
                    imgcard(
                        painter = painter,
                        contentDescription = description,
                        title = title,
                        )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
    Column(horizontalAlignment = Alignment.Start) {

    }
    Row (horizontalArrangement = Arrangement.SpaceBetween ){

    }

}
@Composable
fun imgcard(painter:Painter,
            contentDescription: String,
            title: String,
            modifier: Modifier=Modifier
            )
{
    Card(
        modifier=Modifier.fillMaxWidth().wrapContentSize(),
        shape = RoundedCornerShape(15.dp)
    )
    {
        Box (modifier = Modifier.height(400.dp).padding(top = 3.dp).wrapContentSize().padding(start = 20.dp)){
            Image(painter = painter
                , contentDescription =contentDescription
                 , contentScale = ContentScale.Crop)
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
            , contentAlignment = Alignment.BottomStart
            )
            {
                Text(title, style = TextStyle(color= Color.White, fontSize = 16.sp))
            }
        }

    }




}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }

}