package com.example.wishlistapp2

import android.content.Context
import androidx.compose.runtime.MutableState
import android.widget.Toast
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animate
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.DismissDirection
import androidx.compose.material.DismissValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.rememberDismissState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterialApi::class , ExperimentalMaterial3Api::class)
@Composable
fun HomeView(modifier: Modifier = Modifier,
             navController : NavController,
             viewModel : WishlistViewModel)
{
    val context = LocalContext.current
    Scaffold(modifier=modifier,
       topBar ={ AppbarView(title ="Wishlist"
       ) {
           Toast.makeText(context,"clicked",Toast
               .LENGTH_LONG).show()}


       },
        floatingActionButton = {
            FloatingActionButton(modifier = Modifier.padding(20.dp)
                , containerColor = Color.White
                , contentColor = Color.Black
                , onClick = {

              navController.navigate(Screen.Addscreen.route + "/0L")


            }) {
                Icon(imageVector = Icons.Filled.Add , contentDescription = "")
            }
        }
    ) {
        val wishlist =viewModel.getAllWishes.collectAsState(initial = listOf())

        LazyColumn(
            modifier
                .padding(it)
                .fillMaxSize()) {
            items(wishlist.value, key = { Wish -> Wish.id  }){
                wish->
                val dissmissState = rememberDismissState(
                    confirmStateChange = {
                        if (it== DismissValue.DismissedToStart || it== DismissValue.DismissedToEnd) {
                            viewModel.deleteAWish(wish)

                        }
                        true
                    }
                )
                SwipeToDismiss(state = dissmissState
                    , background ={
                        val color by animateColorAsState(
                            if(dissmissState.dismissDirection == androidx.compose.material
                                .DismissDirection.EndToStart) Color.Cyan else Color.Transparent ,
                            label = ""
                        )
                        val alignment = Alignment.CenterEnd

                        Box (
                            modifier = Modifier.fillMaxSize()
                               .background(color)
                                .padding(horizontal = 20.dp),
                            contentAlignment = alignment

                        ){
                            Icon(Icons.Default.Delete, contentDescription = null, tint = Color.White)
                               // Text("Delete", color = color, modifier = Modifier.align
                        // (alignment))
                        }


                    }
                    , directions = setOf(androidx.compose.material.DismissDirection.StartToEnd,
                        androidx.compose.material.DismissDirection.EndToStart)
                    , dismissThresholds = {FractionalThreshold(1f)}
                    , dismissContent = {
                        WishItem(wish = wish, onclick = {
                            val id= wish.id
                            navController.navigate(Screen.Addscreen.route + "/$id")
                    }

                )


                }
                )


            }

        }
    }
}

@Composable
fun WishItem(wish:Wish,onclick: () -> Unit)
{
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 8.dp , start = 8.dp , end = 8.dp)
        .clickable {
            onclick()
        } ,
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = wish.title, fontWeight = FontWeight.ExtraBold )
            Text(text = wish.description)

        }


    }

}
