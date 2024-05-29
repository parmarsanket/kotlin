package com.example.mywishlistapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mywishlistapp.data.Wish
import com.example.mywishlistapp.data.Wishrepositry
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class WishViewModel(
    private val wishrepositry: Wishrepositry= Graph.withRepository
):ViewModel() {
      var wishTitleState by mutableStateOf("")
    var wishDescriptionState by mutableStateOf("")

   fun onWishTitleChanged(newString: String)
   {
       wishTitleState=newString
   }
    fun onWishDescreptionChange(newString: String)
    {
        wishDescriptionState=newString
    }

    fun addWish(wish: Wish) {
        viewModelScope.launch (Dispatchers.IO) {
            wishrepositry.addAWish(wish = wish)
        }
    }

    lateinit var getALLWishes:Flow<List<Wish>>
init {
    viewModelScope.launch {
        getALLWishes=wishrepositry.getWishes()
    }

    fun updateWish(wish: Wish)
    {
        viewModelScope.launch (Dispatchers.IO){
            wishrepositry.updateAWish(wish = wish)
        }
    }
    fun getWishById(id:Long):Flow<Wish>
    {
        return wishrepositry.getAWishById(id)
    }
    fun deleteWish(wish: Wish)
    {
        viewModelScope.launch (Dispatchers.IO){
            wishrepositry.deleteAWish(wish = wish)
        }
    }
}

}



