package kz.tutorial.jsonplaceholdertypicode

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    lateinit var rvPosts: RecyclerView
    lateinit var postsAdapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupAdapter()
        setupRecycler()
        loadPosts()
    }

    private fun setupAdapter() {
        postsAdapter = PostAdapter(layoutInflater)
        postsAdapter.listener = ClickListener { showToast("Post = ${it.title}") }
    }

    private fun setupRecycler() {
        rvPosts = findViewById(R.id.rv_posts)
        rvPosts.adapter = postsAdapter

        val layoutManager = LinearLayoutManager(this)
        rvPosts.layoutManager = layoutManager

        val spaceItemDecoration = SpaceItemDecoration(verticalSpaceInDp = 8, horizontalSpaceInDp = 16)
        rvPosts.addItemDecoration(spaceItemDecoration)
    }

    private fun loadPosts() {
        lifecycleScope.launch {
            val posts = NetworkManager.apiService.getPosts()
            withContext(Dispatchers.Main) {
                postsAdapter.setData(posts)
            }
        }
    }
}