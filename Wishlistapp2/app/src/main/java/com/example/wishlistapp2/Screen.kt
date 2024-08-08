package com.example.wishlistapp2

sealed class Screen(val route:String) {
    object Home : Screen("home_screen")
    object Addscreen:Screen("add_screen")

}