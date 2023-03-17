package kz.tutorial.jsonplaceholdertypicode.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import kz.tutorial.jsonplaceholdertypicode.R

class MainActivity : AppCompatActivity() {

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
