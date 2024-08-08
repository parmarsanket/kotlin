package com.example.roomdb

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class Contact(
    @PrimaryKey(autoGenerate = true)  // Automatically generates a unique ID for each Contact instance.  // @PrimaryKey(autoGenerate = true)  // Automatically generates a unique ID for each Contact instance.  // @PrimaryKey(autoGenerate = true)  // Automatically generates a unique ID for each Contact instance.  // @PrimaryKey(autoGenerate = true)  // Automatically generates a unique ID for each Contact instance.  // @PrimaryKey(autoGenerate = true)  // Automatically generates
    val id:Int?=null,
    val firstname : String,
    val lastname : String,
    val phoneNumber : String,
)
