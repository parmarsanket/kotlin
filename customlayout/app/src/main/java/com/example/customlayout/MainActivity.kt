package com.example.customlayout
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.customlayout.ui.theme.CustomlayoutTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomlayoutTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize() ,
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}
@Composable
fun MyButton(text: String, modifier: Modifier = Modifier) {
    Button(
        onClick = { } ,
        modifier = modifier
    ) {
        Text(text)
    }
}

@Composable
fun MainScreen() {
    ConstraintLayout(Modifier.size(width = 400.dp , height = 250.dp)) {
        val (button1 , button2 , button3) = createRefs()

        val guide = createGuidelineFromStart(fraction = .60f)

        MyButton(text = "Button1" , Modifier.constrainAs(button1) {
            top.linkTo(parent.top , margin = 40.dp)
            end.linkTo(guide , margin = 30.dp)
        })

        MyButton(text = "Button2" , Modifier.constrainAs(button2) {
            top.linkTo(button1.bottom , margin = 20.dp)
            start.linkTo(guide , margin = 40.dp)
        })

        MyButton(text = "Button3" , Modifier.constrainAs(button3) {
            top.linkTo(button2.bottom , margin = 40.dp)
            end.linkTo(guide , margin = 20.dp)
        })
    }
}







     

