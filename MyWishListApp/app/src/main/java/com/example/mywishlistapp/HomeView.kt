package com.example.mywishlistapp

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mywishlistapp.data.Dummywish
import com.example.mywishlistapp.data.Wish

@Composable
fun  HomeView(navController: NavController,
              viewModel: WishViewModel){
    val context= LocalContext.current
    Scaffold (
        topBar = {AppBarView(title = "Wishlist",{
                Toast.makeText(context,"Button Clicked",Toast.LENGTH_SHORT).show()
            }
        )},
        floatingActionButton =
        {
            FloatingActionButton(
                onClick = {
                          navController.navigate(Screen.AddSreen.route + "/0l")
                }
                , modifier = Modifier
                    .padding(all = 20.dp)

                , contentColor = Color.White,
                containerColor = Color.Black
                )
                {
                      Icon(imageVector = Icons.Default.Add, contentDescription =null )
                 }
        }
    ){
        val wishList=viewModel.getALLWishes.collectAsState(initial = listOf())
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(it))
        {
items(wishList.value)
{
    wish-> WishItem(wish = wish) {
    val id =wish.id
    navController.navigate(Screen.AddSreen.route+"/$id")

}
}
        }

    }

}
@Composable
fun  WishItem(wish : Wish,onclick:()->Unit)
{
    Card (modifier = Modifier
        .fillMaxWidth()
        .padding(top = 8.dp, end = 8.dp)
        .clickable {
            onclick()
        },
        elevation = CardDefaults.cardElevation(defaultElevation = 20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    )
    {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = wish.title, fontWeight = FontWeight.ExtraBold)
            Text(text = wish.description)
        }

    }

}