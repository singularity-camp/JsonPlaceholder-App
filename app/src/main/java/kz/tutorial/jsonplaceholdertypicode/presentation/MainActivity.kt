package kz.tutorial.jsonplaceholdertypicode.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
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

        bottomNavigationView = findViewById(R.id.nav_view)
        bottomNavigationView.itemIconTintList = null
        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            val navController = findNavController(R.id.nav_fragment_container)
            navController.navigate(menuItem.itemId)
            true
        }
    }
}