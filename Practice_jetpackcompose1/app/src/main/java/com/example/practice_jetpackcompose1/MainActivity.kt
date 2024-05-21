package com.example.practice_jetpackcompose1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practice_jetpackcompose1.ui.theme.Practice_jetpackcompose1Theme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Practice_jetpackcompose1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(4.dp, 8.dp),
                    color = MaterialTheme.colorScheme.background,

                ) {
                    //myapp()
                    itemspage()
                }
            }
        }
    }
}
data class information(
    var name:String,
    var qty:Int
)

@Composable
fun itemspage()
{
    var data = remember {
        mutableStateOf(listOf<information>())
    }
        var showdialogbox = remember {
            mutableStateOf(false)
        }
    var outline1 = remember {
        mutableStateOf("")
    }
    var outline2 = remember {
        mutableStateOf("")
    }
    var size= remember {
        mutableStateOf(0)
    }
    Column (modifier = Modifier.fillMaxSize()){
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically) 
        {
            Button(onClick = { showdialogbox.value=true})
            {
                Text(text = "Add items")
            }
            
        }
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(20.dp))
        {
            items(data.value)
            {
                list(it)
            }


        }

        if(showdialogbox.value)
        {
           AlertDialog(onDismissRequest = { showdialogbox.value=false },title = { Text("Add shoping items") }, confirmButton = { /*TODO*/
               Column{

                OutlinedTextField(
                    value = outline1.value,
                    onValueChange = { outline1.value = it },
                    modifier = Modifier.padding(8.dp)
                )
                OutlinedTextField(
                    value = outline2.value,
                    onValueChange = { outline2.value = it },
                    modifier = Modifier.padding(8.dp)
                )

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically

                )
                {
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "cancel")
                    }
                    Button(onClick = {
                        val newitem = information(
                            name = outline1.value,
                            qty = outline2.value.toIntOrNull()?:1
                        )
                        data.value += newitem
                        outline1.value=""
                        outline2.value=""
                        showdialogbox.value=false
                    }) {
                        Text(text = "Add")
                    }
                }
            }
           })


        }
    }
}
@Composable
fun list(
     it:information
)
{
    Row (
        modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth().fillMaxWidth()
        .border(
            border = BorderStroke(2.dp, Color(0XFF018786)),
            shape = RoundedCornerShape(20)
        )
    ){
        Text(text = "name : "+it.name, modifier = Modifier.padding(10.dp))
        Text(text = "qut  : "+it.qty, modifier = Modifier.padding(10.dp))
    }

}
