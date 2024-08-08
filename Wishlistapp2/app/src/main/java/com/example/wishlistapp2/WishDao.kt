package com.example.wishlistapp2

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
abstract class WishDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun addWish(wishEntity : Wish)
    @Query("SELECT * FROM 'wish-table'")
    abstract fun getAllWishes(): Flow<List<Wish>>

    @Update
    abstract fun updateWish(wishEntity : Wish)

    @Delete
    abstract fun deleteAWishes(wishEntity : Wish)

    @Query("SELECT * FROM 'wish-table'WHERE id = :id")
    abstract fun getAWishesbyid(id:Long): Flow<Wish>

}