package kz.tutorial.jsonplaceholdertypicode

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import kz.tutorial.jsonplaceholdertypicode.presentation.posts.details.PostDetailsViewModel

class FragmentPostDetails : Fragment() {

    private val vm: PostDetailsViewModel by viewModels()

    private lateinit var tvPostTitle: TextView
    private lateinit var tvPostAuthor: TextView
    private lateinit var tvPostBody: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_post_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        initObservers()
    }

    private fun initViews(view: View) {
        with(view) {
            tvPostTitle = findViewById(R.id.post_details_tv_post_title)
            tvPostAuthor = findViewById(R.id.post_details_tv_post_author)
            tvPostBody = findViewById(R.id.post_details_tv_post_body)
        }
    }

    private fun initObservers() {
        vm.postLiveData.observe(viewLifecycleOwner) {
            tvPostTitle.text = it.title
            tvPostAuthor.text = it.id.toString()
            tvPostBody.text = it.body
        }
    }
}