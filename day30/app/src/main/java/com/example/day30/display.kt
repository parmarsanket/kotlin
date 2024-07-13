package com.example.day30

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.day30.ui.theme.Typography


@Composable
fun display(obj:Topic)
{
    var img = painterResource(id = R.drawable.img)
    var expand by remember {
        mutableStateOf(false)
    }
    
    Card(modifier = Modifier
        .fillMaxWidth()
        .wrapContentSize()
        .padding(vertical = 5.dp, horizontal = 9.dp)
    ) {
        Column (modifier = Modifier
            .clickable { expand = !expand }
            .animateContentSize()
            .padding(8.dp)
            .fillMaxWidth()){
            Text(text = stringResource(id = obj.title), style = Typography.bodyLarge)
            Text(text = "Serene Waters",style = Typography.headlineSmall)
            Image(painter = painterResource(id = obj.img) , contentDescription =null )
            if (expand)
            {
                Text(text ="Description : A tranquil scene " +
                        "of smooth, rounded rocks reflected in " +
                        "the still, clear waters under a vast blue sky." +
                        " The natural symmetry and calmness evoke a sense " +
                        "of peace.", style = Typography.titleLarge, textAlign = TextAlign.Justify )
            }

        }
    }

}