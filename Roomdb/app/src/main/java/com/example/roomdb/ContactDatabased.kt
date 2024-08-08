package com.example.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(
    entities = [Contact::class],
    version = 1
)
abstract class ContactDatabased: RoomDatabase() {

    abstract val dao : ContectDao

}