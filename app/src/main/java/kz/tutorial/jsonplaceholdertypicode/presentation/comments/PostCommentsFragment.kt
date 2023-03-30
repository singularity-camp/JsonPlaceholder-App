package kz.tutorial.jsonplaceholdertypicode.presentation.comments

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.presentation.posts.CommentAdapter
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.ClickListener
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.SpaceItemDecoration
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class PostCommentsFragment : Fragment() {

    private val args: PostCommentsFragmentArgs by navArgs()
    private val vm: PostCommentsViewModel by viewModel{
        parametersOf(args.postId)
    }

    private lateinit var rvComments: RecyclerView
    private lateinit var adapter: CommentAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vm
        return inflater.inflate(R.layout.fragment_post_comments, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        initAdapter()
        initRecycler()
        initObservers()
    }

    private fun initViews(view: View) {
        with(view) {
            rvComments = findViewById(R.id.rv_comments)
        }
    }

    private fun initAdapter() {
        adapter = CommentAdapter(layoutInflater)
        adapter.listener = ClickListener {

        }
    }

    private fun initRecycler() {
        val currentContext = context ?: return

        rvComments.adapter = adapter
        rvComments.layoutManager = LinearLayoutManager(currentContext)

        val spaceItemDecoration =
            SpaceItemDecoration(verticalSpaceInDp = 8, horizontalSpaceInDp = 16)
        rvComments.addItemDecoration(spaceItemDecoration)
    }

    private fun initObservers() {
        vm.commentsLiveData.observe(viewLifecycleOwner) {
            Log.i(TAG, it.size.toString())
            adapter.setData(it)
        }
    }


}