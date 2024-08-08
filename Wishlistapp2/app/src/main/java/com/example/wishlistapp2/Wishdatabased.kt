package com.example.wishlistapp2

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [Wish::class],
    version = 1,
    exportSchema = false

)
abstract class Wishdatabased :RoomDatabase(){
    abstract fun wishDao() : WishDao




}