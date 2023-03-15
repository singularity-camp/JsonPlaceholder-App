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
    private lateinit var bnvMainActivity: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initNavigationHost()
        initBottomNavigationBar()
    }

    private fun initNavigationHost() {
        navHostFragmentMainActivity =
            supportFragmentManager.findFragmentById(R.id.nav_host_main) as NavHostFragment
        navControllerMainActivity = navHostFragmentMainActivity.navController
    }

    private fun initBottomNavigationBar() {
        bnvMainActivity = findViewById(R.id.bnv_main)
        bnvMainActivity.setupWithNavController(navControllerMainActivity)
    }
}