package com.example.hikingapp.hike

import android.Manifest
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.hikingapp.R
import com.example.hikingapp.databinding.FragmentHikeBinding
import com.example.hikingapp.location.FusedLocationManager
import com.example.hikingapp.main.ApplicationGraph
import com.example.hikingapp.main.BaseFragment

class HikeFragment(private val fusedLocationManager: FusedLocationManager) : BaseFragment<FragmentHikeBinding>(R.layout.fragment_hike){

    private val viewModel: HikeViewModel by lazy { ViewModelProvider(this).get(HikeViewModel::class.java) }









    private fun checkPermission(){ if(!fusedLocationManager.isLocationEnabledOnDevice()) fusedLocationManager.enableDeviceLocation() }

    companion object{
        private val PERMISSIONS = arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )
        private const val REQUEST_CODE = 26
        fun getInstance(): HikeFragment{
            val fusedLocationManager = ApplicationGraph.getFusedLocationManager()
            return HikeFragment(fusedLocationManager)
        }
    }
}