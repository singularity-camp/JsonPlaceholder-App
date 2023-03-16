package kz.tutorial.jsonplaceholdertypicode.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.presentation.posts.PostsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)


        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container)
        val navController = navHostFragment?.findNavController()

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.postsFragment,
                R.id.albumFragment,
                R.id.usersFragment,
                R.id.profileFragment
            )
        )

        if(navController != null) {
            navView.setupWithNavController(navController)
        }

//        initPostsFragment()
    }

//    private fun initPostsFragment() {
//        supportFragmentManager.beginTransaction()
//            .add(R.id.fl_container, PostsFragment())
//            .commit()
//    }
}