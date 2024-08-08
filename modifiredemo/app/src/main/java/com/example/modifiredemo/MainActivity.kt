package com.example.modifiredemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.UrlAnnotation
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.modifiredemo.ui.theme.ModifiredemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ModifiredemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize() ,
                    color = MaterialTheme.colorScheme.background
                ) {
                    DemoScreen<Any>()

                }
            }
        }
    }
}



@OptIn(ExperimentalTextApi::class)
@Composable
fun <AnnotatedString> DemoScreen() {

     val annotatedLinkString = buildAnnotatedString {
        val str = "Let's open google!"
        val startIndex = str.indexOf("google")
        val endIndex = startIndex + 6
        append(str)
        addStyle(
            style = SpanStyle(
                color = Color.Red,
                textDecoration = TextDecoration.Underline
            ), start = startIndex, end = endIndex
        )
        addUrlAnnotation(
            UrlAnnotation("https://google.com") ,
            start = startIndex,
            end = endIndex
        )
    }

    val uriHandler = LocalUriHandler.current
    ClickableText(
        modifier = Modifier.padding(20.dp).fillMaxWidth(),
        text = annotatedLinkString,
        onClick = {
            annotatedLinkString
                .getUrlAnnotations(it, it)
                .firstOrNull()?.let { annotation ->
                    uriHandler.openUri(annotation.item.url)
                }
        }
    )
    //Text(annotatedLinkString)

}
@Composable
@Preview(showBackground = true)
fun PreviewDemoScreen() {
    DemoScreen<Any>()
}