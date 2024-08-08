package com.example.roomdb

sealed interface ContactEvent {
    object SaveContact:ContactEvent
   data class setFristname(val Fristname: String) : ContactEvent
    data class setLastname(val Lastname: String) : ContactEvent
    data class setphoneNumber(val phoneNumber: String) : ContactEvent

    object ShowDialog:ContactEvent
    object HideDialog:ContactEvent

    data class SortContact(val sortTarget:SortType):ContactEvent
    data class DeleteContact( val contact : Contact):ContactEvent
}