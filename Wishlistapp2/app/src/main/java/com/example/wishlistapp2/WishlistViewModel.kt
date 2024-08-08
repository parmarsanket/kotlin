package com.example.wishlistapp2

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class WishlistViewModel(
    private val wishrepository : Wishrepository = Graph.wishrepository
):ViewModel (){

    var wishTileSate by mutableStateOf("")
    var wishDescriptionState by mutableStateOf("")

    fun onwishTileStateChanged(newString: String) {
        wishTileSate = newString
    }
    fun onWishDescriptionStateChanged(newString: String) {
        wishDescriptionState = newString
    }

   lateinit var getAllWishes : Flow<List<Wish>>

   init {
       viewModelScope.launch {
           getAllWishes = wishrepository.getWishes()
       }
   }
    fun addWish(wish: Wish) = viewModelScope.launch(Dispatchers.IO) {
        wishrepository.addwish(wish = wish)
    }

    fun updateWish(wish: Wish) = viewModelScope.launch(Dispatchers.IO) {
        wishrepository.updateWish(wish = wish)
    }

    fun deleteAWish(wish: Wish) = viewModelScope.launch(Dispatchers.IO) {
        wishrepository.deleteAwish(wish = wish)
    }


    fun getwishbyid(id:Long):Flow<Wish>
    {
        return wishrepository.getWishesbyid(id = id)
    }
}