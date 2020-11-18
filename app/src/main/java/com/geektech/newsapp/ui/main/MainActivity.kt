package com.geektech.newsapp.ui.main

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import com.geektech.newsapp.R
import com.geektech.newsapp.data.NewsRepository
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
    , NavigationView.OnNavigationItemSelectedListener
{

    private lateinit var drawerLayout: DrawerLayout;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("ololo", "onCreate: ")
        val toolbar = findViewById<Toolbar>(R.id.main_toolbar)
        setSupportActionBar(toolbar)
        drawerLayout = findViewById(R.id.drawer_layout)
        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        val toggle =
            ActionBarDrawerToggle(
                this, drawerLayout, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
            )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container,
                MainFragment()
            ).commit()
            navigationView.setCheckedItem(R.id.nav_shop)

        }
//        repository.isLoading.observe(this,  Observer<Boolean>() {
//            Log.d("ololo", "onCreate: $it")
//            if (it) {
//                loading_lottie.visibility = View.GONE
//                fragment_container.visibility = View.VISIBLE
//            } else {
//                fragment_container.visibility = View.GONE
//                loading_lottie.visibility = View.VISIBLE
//                }
//        })
//        repository.loading()
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.dots, menu)
        return super.onCreateOptionsMenu(menu)
    }
}