package com.example.hikingapp.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.hikingapp.R
import com.example.hikingapp.databinding.ActivityMainBinding
import com.example.hikingapp.databinding.ActivitySplashBinding
import com.example.hikingapp.hike.HikeFragment
import com.google.android.gms.maps.MapFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setBottomNav()
        if(supportFragmentManager.findFragmentById(R.id.fragment_container)==null) supportFragmentManager.beginTransaction().add(R.id.fragment_container, HikeFragment.getInstance()).commit()

    }//onCreate()

    private fun setBottomNav(){
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.bottomNavigationView_bicycle -> {
                    changeFragment(HikeFragment.getInstance())
                    true
                }
                R.id.bottomNavigationView_history -> {
                    //changeFragment(HistoryFragment.getInstance())
                    true
                }
                R.id.bottomNavigationView_map ->{
                    //changeFragment(MapFragment.getInstance())
                    true
                }
                else -> true
            } //when
        }//setOnItemSelectedListener
    }//setBottomNav()

    private fun changeFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()
    }
}