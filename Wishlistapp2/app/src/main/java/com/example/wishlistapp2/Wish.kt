package com.example.wishlistapp2

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Wish-table")
data class Wish(
    @PrimaryKey(autoGenerate = true)  // Automatically generates a unique ID for each Wish object. If you don't want auto-generation, you can remove this line and add a unique ID column in the database schema.  // Automatically generates a unique ID for each Wish object. If you don't want auto-generation, you can remove this line and add a unique ID column in the database schema.  // Automatically generates a unique ID for each Wish object. If you don
    val id:Long = 0L,
    @ColumnInfo("wish-title")
    val title: String="",
    @ColumnInfo("wish-description")
    val description: String="",
)

object dummyWish
{
    val Wishlist = listOf(
        Wish(title = "Book", description = "A classic novel"),
        Wish(title = "Phone", description = "A powerful device"),
        Wish(title = "Laptop", description = "A powerful computer"),
        Wish(title = "Headphones", description = "Sound quality for listening"),
        Wish(title = "Mouse", description = "A mouse for controlling devices"),
        Wish(title = "Keyboard", description = "A keyboard for typing"),
        Wish(title = "Monitor", description = "A monitor for viewing your desktop"),
        Wish(title = "Router", description = "A router for connecting devices"),
        Wish(title = "Switch", description = "A switch for controlling devices"),
        Wish(title = "Speaker", description = "A speaker for sounding loud"),
        Wish(title = "Pen", description = "A pen for writing")

    )

}
