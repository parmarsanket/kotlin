package com.example.wishlistapp2

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument


@Composable
fun Navigation(viewModel : WishlistViewModel = viewModel(),navController : NavHostController =
    rememberNavController())
{
   NavHost(navController =navController  ,
       startDestination =Screen.Home.route ) {
       composable(Screen.Home.route)
       {
           HomeView(
               modifier = Modifier
                   .statusBarsPadding()
                   .navigationBarsPadding(),
               navController = navController,
               viewModel = viewModel
           )
       }
       composable(Screen.Addscreen.route + "/{id}",
           arguments = listOf(
               navArgument("id")
               {
                   type = NavType.LongType
                   defaultValue = 0L
                   nullable= false
               }
           )
       )
       {entry ->
           val id = if (entry.arguments != null) entry.arguments !!.getLong("id") else 0L
           AddEditDetailView(
               id = id,
               viewModel = viewModel,
               navController = navController,
               modifier = Modifier
                   .statusBarsPadding()
                   .navigationBarsPadding()
           )
       }

   }


}