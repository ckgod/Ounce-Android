package com.example.ounceaos.ui.activity

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import com.example.ounceaos.R
import com.example.ounceaos.databinding.ActivityMainBinding
import com.example.ounceaos.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    private var currentNavController: LiveData<NavController>? = null

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.addOnBackStackChangedListener {
            val backStackEntryCount = supportFragmentManager.backStackEntryCount
            val fragments = supportFragmentManager.fragments
            val fragmentCount = fragments.size
        }

        if (savedInstanceState == null) {
            binding.bottomNav.selectedItemId = R.id.home
        } // Else, need to wait for onRestoreInstanceState
    }

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onResume() {
        super.onResume()
        binding.bottomNav.itemIconTintList = null
        setupBottomNavigationBar()
    }

    @RequiresApi(Build.VERSION_CODES.S)
    fun setupBottomNavigationBar() {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_nav)

        val navGraphIds = listOf(
            R.navigation.nav_home,
            R.navigation.nav_feed,
            R.navigation.nav_make_group,
            R.navigation.nav_ranking,
            R.navigation.nav_profile
        )

        // Setup the bottom navigation view with a list of navigation graphs
        val controller = bottomNavigationView.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.nav_host_fragment_container_in_main_activity,
            intent = intent
        )

        currentNavController = controller
//        subscribeBottomNavigation(currentNavController!!)
    }

    fun setBottomNavVisible(flag : Boolean){
        binding.bottomNav.visibility = if(flag) View.VISIBLE else View.GONE
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration)
    }
}