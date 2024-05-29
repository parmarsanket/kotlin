package com.example.mywishlistapp.data

import android.accounts.AuthenticatorDescription
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName ="wish_table" )
data class Wish(
    @PrimaryKey(autoGenerate = true)
    val id :Long =0L,
    @ColumnInfo(name = "wish_title")
    val title : String="",
    @ColumnInfo(name = "wish_desc")
    val description: String=""
)
object Dummywish
{
    val withList = listOf(
        Wish(title = "Google Watch", description = "An andoird watch")
    )
}
