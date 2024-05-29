package com.example.mywishlistapp.data


import kotlinx.coroutines.flow.Flow
class Wishrepositry(private  val wishDao: WishDao) {
    suspend fun addAWish(wish: Wish)
    {
        wishDao.addWish(wish)
    }
    fun getWishes():Flow<List<Wish>> = wishDao.getAllWishes()

    fun getAWishById(id:Long):Flow<Wish>{
        return wishDao.getAWishId(id)
    }
    suspend fun updateAWish(wish: Wish)
    {
        wishDao.updateAWish(wish)
    }
    suspend fun deleteAWish(wish: Wish)
    {
        wishDao.DeleteAWish(wish)
    }
}