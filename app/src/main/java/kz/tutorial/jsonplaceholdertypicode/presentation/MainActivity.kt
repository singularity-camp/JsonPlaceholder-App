package kz.tutorial.jsonplaceholdertypicode.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import kz.tutorial.jsonplaceholdertypicode.R

class MainActivity : AppCompatActivity() {

    private lateinit var navHostFragmentMainActivity: NavHostFragment
    private lateinit var navControllerMainActivity: NavController
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initNavigationHost()
        initBottomNavigation()
    }

    private fun initBottomNavigation() {
        navHostFragmentMainActivity =
            supportFragmentManager.findFragmentById(R.id.nav_fragment_container) as NavHostFragment
        navControllerMainActivity = navHostFragmentMainActivity.navController
    }

    private fun initNavigationHost() {
        bottomNavigationView = findViewById(R.id.nav_view)
        bottomNavigationView.setupWithNavController(navControllerMainActivity)
    }
}



