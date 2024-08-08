package com.example.wishlistapp2

import android.content.Context
import androidx.room.Database
import androidx.room.Room

object Graph {
    lateinit var database : Wishdatabased

    val wishrepository by lazy {
        Wishrepository(wishDao = database.wishDao())
    }
    fun provide(context: Context)
    {
        database = Room.databaseBuilder(context = context,
            Wishdatabased::class.java,
            "wishlist.db")
           .build()
    }
}