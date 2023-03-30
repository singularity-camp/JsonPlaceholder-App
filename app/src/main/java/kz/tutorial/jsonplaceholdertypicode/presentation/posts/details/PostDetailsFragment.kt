package kz.tutorial.jsonplaceholdertypicode.presentation.posts.details

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.domain.models.User
import kz.tutorial.jsonplaceholdertypicode.presentation.posts.CommentAdapter
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.SpaceItemDecoration
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class PostDetailsFragment : Fragment() {
    private lateinit var postTitleTextView: TextView
    private lateinit var postAuthorTextView: TextView
    private lateinit var postContentTextView: TextView
    private lateinit var postShowAllTextView: TextView
    private lateinit var commentsRecyclerView: RecyclerView

    private val args: PostDetailsFragmentArgs by navArgs()
    private val vm: PostDetailsViewModel by viewModel {
        parametersOf(args.postId)
    }


    private lateinit var adapter: CommentAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        vm
        return inflater.inflate(R.layout.fragment_post_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews(view)
        initAdapter()
        initRecycler()
        initObservers()
    }

    private fun initViews(view: View) {

        postTitleTextView = view.findViewById(R.id.tv_title)
        postAuthorTextView = view.findViewById(R.id.tv_author)
        postContentTextView = view.findViewById(R.id.tv_content)
        commentsRecyclerView = view.findViewById(R.id.rv_five_comments)
        postShowAllTextView = view.findViewById(R.id.show_all)


        postShowAllTextView.setOnClickListener {
            Log.i(TAG, args.postId.toString())
            findNavController().navigate(
                PostDetailsFragmentDirections.actionPostDetailsFragmentToPostCommentsFragment(args.postId)
            )
        }
    }

    private fun initAdapter() {
        adapter = CommentAdapter(layoutInflater)
    }

    private fun initRecycler() {
        commentsRecyclerView.adapter = adapter
        commentsRecyclerView.layoutManager = LinearLayoutManager(context ?: return)

        val spaceItemDecoration =
            SpaceItemDecoration(verticalSpaceInDp = 8, horizontalSpaceInDp = 16)
        commentsRecyclerView.addItemDecoration(spaceItemDecoration)
    }

    private fun initObservers() {
        vm.post.observe(viewLifecycleOwner) {
            postTitleTextView.text = it.title
            postContentTextView.text = it.body
        }
        vm.comments.observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
        vm.author.observe(viewLifecycleOwner) {
            onAuthorUpdated(it)
        }
    }

    private fun onAuthorUpdated(author: User) {
        postAuthorTextView.text = author.name
    }
}