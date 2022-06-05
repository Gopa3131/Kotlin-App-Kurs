package com.example.kusovaya

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavMenu : BottomNavigationView = findViewById(R.id.bottom_navigation_menu)
        val myNavController : NavController = findNavController(R.id.nav_host_fragment)

        val appBarConfiguration : AppBarConfiguration = AppBarConfiguration(setOf(R.id.counterFragment, R.id.rateFragment, R.id.historyFragment, R.id.profileFragment))
        setupActionBarWithNavController(myNavController, appBarConfiguration)

        bottomNavMenu.setupWithNavController(myNavController)
    }
}