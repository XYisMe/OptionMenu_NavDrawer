package com.example.bottomnavview

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.view.menu.MenuBuilder
import androidx.core.view.GravityCompat
import androidx.core.view.MenuCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    var appBarConfiguration: AppBarConfiguration? = null
    var drawer: DrawerLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = this.findNavController(R.id.nav_host_fragment_activity_main)
        val navView = findViewById<BottomNavigationView>(R.id.bottom_nav_view)

        navView.setupWithNavController(navController)

        //for transparent background
        navView.background = null

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener{
            navController.navigate(R.id.scan)
        }

        //navigation view
        drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        val navigationView = findViewById<NavigationView>(R.id.nav_view)

        // AppBarConfiguration appBarConfiguration;
        appBarConfiguration = AppBarConfiguration.Builder(navController.graph).setOpenableLayout(drawer).build()

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration!!)
        NavigationUI.setupWithNavController(navigationView, navController)

        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(this);
        }

    }

    //NAVView
    // This method is called whenever the user chooses to navigate Up within your application's activity hierarchy from the action bar.
    override fun onSupportNavigateUp(): Boolean {
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main)
        val navigated = NavigationUI.navigateUp(navController, appBarConfiguration!!)
        return (navigated || super.onSupportNavigateUp())
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean{
        val id = item.itemId
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        return when(id){
            R.id.logout ->{
                val intent:Intent = Intent(this@MainActivity, LoginActivity::class.java)
                startActivity(intent)
                drawer?.closeDrawer(GravityCompat.START)
                true
            }

            else ->{
                super.onNavigateUp()
            }
        }
    }

    //option menu
    @SuppressLint("RestrictedApi")
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)

        if(menu is MenuBuilder){
            menu.setOptionalIconsVisible(true)
        }

        MenuCompat.setGroupDividerEnabled(menu, false)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        val navController = this.findNavController(R.id.nav_host_fragment_activity_main)

        return when(id){
            R.id.home -> {
                navController.navigate(R.id.home)
                true
            }
            R.id.scan -> {
                navController.navigate(R.id.scan)
                true
            }
            R.id.profile -> {
                navController.navigate(R.id.profile)
                true
            }
            R.id.logout ->{
                val intent:Intent = Intent(this@MainActivity, LoginActivity::class.java)
                startActivity(intent)
                true
            }

            else ->{
                super.onOptionsItemSelected(item)
            }
        }

    }

}



// Fragments
// Menu: bottom navigation menu xml
// Navigation Graph: navigation_graph.xml (Jetpack, AndroidX)

// Activity.xml - > main container for fragment