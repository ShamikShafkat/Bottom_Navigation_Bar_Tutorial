package com.example.sharencare

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.sharencare.databinding.ActivityMainBinding
import com.example.sharencare.fragment.Favorites_Fragment
import com.example.sharencare.fragment.Music_Fragment
import com.example.sharencare.fragment.Notifications_Fragment
import com.example.sharencare.fragment.Place_Fragment

class MainActivity : AppCompatActivity() {

    private var selectedFragment :Fragment ?= null

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.nav_favourites -> {
                selectedFragment = Favorites_Fragment()
            }
            R.id.nav_music -> {
                selectedFragment = Music_Fragment()
            }
            R.id.nav_place -> {
                selectedFragment = Place_Fragment()
            }
            R.id.nav_notifications -> {
                selectedFragment = Notifications_Fragment()
            }
        }

        if(selectedFragment!=null)
        {
            supportFragmentManager.beginTransaction().replace(R.id.frame_layout,selectedFragment!!).commit()
            return@OnNavigationItemSelectedListener true
        }

        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView : BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        supportFragmentManager.beginTransaction().replace(R.id.frame_layout,Favorites_Fragment()).commit()

        var badge_notifications = navView.getOrCreateBadge(R.id.nav_notifications)
        badge_notifications.isVisible = true
        badge_notifications.number = 1

        var badge_place = navView.getOrCreateBadge(R.id.nav_place)
        badge_place.isVisible = true
    }
}