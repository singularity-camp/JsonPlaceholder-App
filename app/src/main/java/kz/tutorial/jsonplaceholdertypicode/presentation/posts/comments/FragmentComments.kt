package kz.tutorial.jsonplaceholdertypicode.presentation.posts.comments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.constants.POST_ID
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.SpaceItemDecoration
import org.koin.androidx.viewmodel.ext.android.viewModel

class FragmentComments : Fragment() {
    private val vmComments: CommentsViewModel by viewModel()

    private lateinit var rvComments: RecyclerView
    private lateinit var rvAdapter: CommentsAdapter
    private lateinit var rvLayoutManager: LinearLayoutManager
    private var postID: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_comments, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews(view)
        getPostID()
        initRecyclerView()
        initContent()
        initObservers()
    }

    private fun initViews(view: View) {
        rvComments = view.findViewById(R.id.comments_rv_comments)
    }

    private fun getPostID() {
        postID = arguments?.getInt(POST_ID)
    }

    private fun initRecyclerView() {
        rvAdapter = CommentsAdapter(layoutInflater)
        rvComments.adapter = rvAdapter
        rvLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvComments.layoutManager = rvLayoutManager
        val spaceItemDecoration =
            SpaceItemDecoration(verticalSpaceInDp = 8, horizontalSpaceInDp = 2)
        rvComments.addItemDecoration(spaceItemDecoration)
    }

    private fun initContent() {
        vmComments.setPostID(postID)
    }

    private fun initObservers() {
        vmComments.commentsLiveData.observe(viewLifecycleOwner) {
            rvAdapter.setData(it)
        }
    }

}