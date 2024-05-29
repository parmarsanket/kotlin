package com.example.myrecipeapp

import android.health.connect.datatypes.ExerciseRoute

sealed class Screen (val route:String){

    object RecipeScreen:Screen("recipescreen")
    object detailScreen:Screen("detailscreen")
}