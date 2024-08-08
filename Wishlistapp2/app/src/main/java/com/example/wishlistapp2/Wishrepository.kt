package com.example.wishlistapp2

import kotlinx.coroutines.flow.Flow

class Wishrepository (private val wishDao : WishDao){

    suspend fun addwish(wish: Wish)
    {
        wishDao.addWish(wish)
    }
    fun getWishes(): Flow<List<Wish>> = wishDao.getAllWishes()

    suspend fun updateWish(wish: Wish)
    {
        wishDao.updateWish(wish)
    }

    fun getWishesbyid(id:Long): Flow<Wish> = wishDao.getAWishesbyid(id)

     suspend fun deleteAwish(wish: Wish)
     {
         wishDao.deleteAWishes(wish)
     }

}