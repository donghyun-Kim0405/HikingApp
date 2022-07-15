package com.example.hikingapp.main

import android.annotation.SuppressLint
import android.content.Context
import com.example.hikingapp.location.FusedLocationModule

class ApplicationGraph(private val context: Context) {

    private val fusedLocationManagerInternal by lazy { FusedLocationModule(context).createFusedLocationManager() }


    companion object{
        @JvmStatic
        @SuppressLint("StaticFieldLeak")
        private var graph: ApplicationGraph? = null

        @JvmStatic
        fun init(context: Context) {
            if (graph == null) {
                graph = ApplicationGraph(context.applicationContext)
            }
        }

        fun getFusedLocationManager() = graph!!.fusedLocationManagerInternal

    }


}