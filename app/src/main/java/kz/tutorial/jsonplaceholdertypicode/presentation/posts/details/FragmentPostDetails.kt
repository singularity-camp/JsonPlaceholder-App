package kz.tutorial.jsonplaceholdertypicode.presentation.posts.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.constants.POST_ID
import kz.tutorial.jsonplaceholdertypicode.presentation.posts.comments.CommentsAdapter
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.SpaceItemDecoration
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.extensions.startEmail
import org.koin.androidx.viewmodel.ext.android.viewModel

class FragmentPostDetails : Fragment() {

    private val vmPost: PostDetailsViewModel by viewModel()

    private lateinit var tvPostTitle: TextView
    private lateinit var tvPostAuthor: TextView
    private lateinit var tvPostBody: TextView
    private lateinit var tvShowAllComments: TextView
    private lateinit var rvPostComments: RecyclerView
    private lateinit var rvAdapter: CommentsAdapter
    private lateinit var rvLayoutManager: LinearLayoutManager
    private var postID: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_post_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews(view)
        getPostID()
        initShowAllCommentsBtn()
        initRecyclerView()
        initContent()
        initObservers()
    }

    private fun initViews(view: View) {
        with(view) {
            tvPostTitle = findViewById(R.id.post_details_tv_post_title)
            tvPostAuthor = findViewById(R.id.post_details_tv_post_author)
            tvPostBody = findViewById(R.id.post_details_tv_post_body)
            tvShowAllComments = findViewById(R.id.post_details_tv_show_all)
            rvPostComments = findViewById(R.id.post_details_rv_comments)
        }
    }

    private fun getPostID() {
        postID = arguments?.getInt(POST_ID)
    }

    private fun initShowAllCommentsBtn() {
        tvShowAllComments.setOnClickListener {
            val bundle = bundleOf(POST_ID to postID)
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_fragmentPostDetails_to_fragmentComments, bundle)
        }
    }

    private fun initRecyclerView() {
        rvAdapter = CommentsAdapter(layoutInflater, this::onEmailClick)
        rvPostComments.adapter = rvAdapter
        rvLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvPostComments.layoutManager = rvLayoutManager
        val spaceItemDecoration =
            SpaceItemDecoration(verticalSpaceInDp = 8, horizontalSpaceInDp = 2)
        rvPostComments.addItemDecoration(spaceItemDecoration)
    }

    private fun onEmailClick(email: String) {
        //Проверьте startEmail чтобы посмотреть что происходит под капотом
        context?.startEmail(email)
    }

    private fun initContent() {
        postID = arguments?.getInt(POST_ID)
        vmPost.setPostID(postID)
    }

    private fun initObservers() {
        vmPost.postLiveData.observe(viewLifecycleOwner) {
            tvPostTitle.text = it.title
            tvPostBody.text = it.body
        }

        vmPost.commentsLiveData.observe(viewLifecycleOwner) {
            rvAdapter.setData(it)
        }

        vmPost.userLiveData.observe(viewLifecycleOwner) {
            tvPostAuthor.text = it.name
        }
    }

}