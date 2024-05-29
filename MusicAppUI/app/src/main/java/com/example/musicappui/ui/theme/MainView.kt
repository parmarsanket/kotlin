package com.example.musicappui.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.musicappui.Screen
import com.example.musicappui.screenInDrawer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView(){

    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val scope:CoroutineScope= rememberCoroutineScope()

    val controller: NavController = rememberNavController()
    val navBackStackEntry by controller.currentBackStackEntryAsState()
val currentRoute=navBackStackEntry?.destination?.route

    val title= remember {
        mutableStateOf("")
    }
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Home") },
                navigationIcon =
                { IconButton(onClick =
                    {
                         //open the drawer
                        scope.launch {
                            scaffoldState.drawerState.open()
                        }
                    })
                   {
                      Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Menu")
                  }
                }
            )

        },
        scaffoldState = scaffoldState,
        drawerContent = {
            LazyColumn(Modifier.padding(16.dp))
            {
                items(screenInDrawer)
                {
item ->
                    DrawerItem(selected = currentRoute==item.dRoute, item = item) {
                        scope.launch {
                            scaffoldState.drawerState.close()
                        }
                        if(item.dRoute=="add_account") {
                            //open dailog
                        }
                        else{
                            controller.navigate(item.dRoute)
                            title.value=item.dtitle
                        }

                    }
                }

            }
        }


    ) {
        Text(text = "", modifier = Modifier.padding(it))
    }
}
@Composable
fun DrawerItem(
    selected:Boolean,
    item:Screen.DrawerScreen,
    onDrwerItemClicked:()->Unit
)
{
    val background =if(selected)Color.DarkGray else Color.White
    Row (modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 8.dp, vertical = 16.dp)
        .background(background)
        .clickable {
            onDrwerItemClicked()
        }
    ){
        androidx.compose.material.Icon(painter = painterResource(id = item.icon)
            , contentDescription = item.dtitle
            ,Modifier.padding(end = 8.dp, top = 4.dp)
        )
        Text(text = item.dtitle, style = MaterialTheme.typography.h5)
    }


}