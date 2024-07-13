package com.example.buildsuperheroesapp

import android.print.PrintAttributes.Margins
import android.view.Display
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buildsuperheroesapp.ui.theme.Typography
import java.lang.reflect.Type

@Composable
fun Display(obj:Hero) {
    Card (modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp)

        .wrapContentSize(align = Alignment.Center)


    ){


        Row(modifier = Modifier.padding(16.dp)) {
            Box (modifier = Modifier.weight(1f)){
                Column() {
                    Text(
                        text = stringResource(id = obj.nameRes),
                        style = MaterialTheme.typography.displaySmall
                    )

                    Text(
                        text = stringResource(id = obj.descriptionRes),
                        textAlign = TextAlign.Justify,
                        style = MaterialTheme.typography.bodyLarge
                    )

                }
            }
            Spacer(modifier = Modifier.padding(8.dp))
            Box (){
                Image(painter = painterResource(id = obj.imageRes) , contentDescription = null,
                    modifier = Modifier.size(72.dp))
            }
        }
    }
}