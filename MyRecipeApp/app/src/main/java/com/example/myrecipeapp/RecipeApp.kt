package com.example.myrecipeapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun RecipeApp(navController: NavHostController)
{
    val recipeViewModel:MainViewModel= viewModel()
    val viewstate by recipeViewModel.categoriesState

    NavHost(navController = navController, startDestination =Screen.RecipeScreen.route )
    {
        composable(Screen.RecipeScreen.route){
            RecipeScreen(viewstate = viewstate, navigateToDetail ={

                navController.currentBackStackEntry?.savedStateHandle?.set("cat",it)
                navController.navigate(Screen.detailScreen.route)
            } )
        }
        composable(route=Screen.detailScreen.route)
        {
            val category=navController.previousBackStackEntry?.savedStateHandle?.
            get<Category>("cat")?: Category("","","","")
            CategoryDetailScreen(category = category)
        }


    }
    

}