package com.example.hikingapp.main

import android.app.Application

class HikeApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ApplicationGraph.init(this)
    }
}