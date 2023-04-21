package kz.tutorial.jsonplaceholdertypicode.presentation.posts.newpost

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import kz.tutorial.jsonplaceholdertypicode.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewPostFragment : Fragment() {

    private val vmNewPost: NewPostViewModel by viewModel()

    private lateinit var etTitle: EditText
    private lateinit var etBody: EditText
    private lateinit var btnCreatePost: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_new_post, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViews(view)
        initButton()
    }

    private fun initViews(view: View) {
        with(view) {
            etTitle = findViewById(R.id.new_post_et_title)
            etBody = findViewById(R.id.new_post_et_body)
            btnCreatePost = findViewById(R.id.new_post_btn_create)
        }
    }

    private fun initButton() {
        btnCreatePost.setOnClickListener {
            val title = etTitle.text.toString()
            val body = etBody.text.toString()
            vmNewPost.submitPost(title = title, body = body)
        }
    }
}