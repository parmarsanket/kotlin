package com.example.wishlistapp2

import android.app.Application

class Wishlistapp: Application() {
    override fun onCreate()
    {
        super.onCreate()
        // Initialize any singleton objects here
        Graph.provide(this)
    }
}