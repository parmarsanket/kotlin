package com.example.roomdb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface ContectDao {
   @Upsert
   suspend fun insertContact(contact: Contact)

    @Delete
   suspend fun deleteContact(contact: Contact)

@Query("SELECT * FROM contact   ORDER BY firstname ASC ")
   fun getContactsOrderbyFirstname(contact: Contact):Flow<List<Contact>>

    @Query("SELECT * FROM contact   ORDER BY lastname ASC ")
    fun getContactsOrderbyLasttname(contact: Contact):Flow<List<Contact>>

    @Query("SELECT * FROM contact   ORDER BY phoneNumber ASC ")
    fun getContactsOrderbyphonenumber(contact: Contact):Flow<List<Contact>>




}