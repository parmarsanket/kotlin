package com.example.mywishlistapp


sealed class Screen (val route:String){
    object HomeScreen : Screen("home_Screen")
    object AddSreen:Screen(route = "add_Screen")
}