package kz.tutorial.jsonplaceholdertypicode.presentation.posts

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.ClickListener
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.SpaceItemDecoration
import org.koin.androidx.viewmodel.ext.android.viewModel

class PostCommentsFragment : Fragment() {

    private val vm: PostCommentsViewModel by viewModel()
    val args: PostCommentsFragmentArgs by navArgs()

    lateinit var rvComments: RecyclerView
    lateinit var adapter: CommentsAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_post_comments, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val currId = args.postId
        vm.userId = currId

        initViews(view)
        initAdapter()
        initRecycler()
        initObservers()
    }

    private fun initViews(view : View) {
        rvComments = view.findViewById(R.id.rv_comments_max)
    }

    private fun initAdapter() {
        adapter = CommentsAdapter(layoutInflater)
        adapter.listener = ClickListener {

        }
    }

    private fun initRecycler() {
        val currentContext = context ?: return

        rvComments.adapter = adapter
        rvComments.layoutManager = LinearLayoutManager(currentContext)

        val spaceItemDecoration = SpaceItemDecoration(verticalSpaceInDp = 8, horizontalSpaceInDp = 16)
        rvComments.addItemDecoration(spaceItemDecoration)
    }

    private fun initObservers() {
        vm.commentsLiveData.observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
    }



}