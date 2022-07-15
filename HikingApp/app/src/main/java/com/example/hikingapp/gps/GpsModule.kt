package com.example.hikingapp.gps

import android.content.Context

class GpsModule(private val context: Context) {
    fun createGpsManager(): GpsManager{
        return GpsManagerImpl(context)
    }
}