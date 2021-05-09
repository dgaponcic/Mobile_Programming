package com.project.lab1.menu

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.project.lab1.R
import com.project.lab1.databinding.ActivityNavigationBinding

class NavigationActivity: AppCompatActivity() {
    private lateinit var binding: ActivityNavigationBinding
    private lateinit var drawerCoordinator: DrawerCoordinator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initDrawer()
    }


    private fun initDrawer() {
        setSupportActionBar(binding.toolbar)

        val toggle = ActionBarDrawerToggle(
                this,
                binding.drawerLayout,
                binding.toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        )

        drawerCoordinator = DrawerCoordinator(
                binding.drawerLayout,
                binding.navView,
                toggle,
                Navigator(this)
        )
    }
}