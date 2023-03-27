package kz.tutorial.jsonplaceholdertypicode.presentation.posts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.ClickListener
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.SpaceItemDecoration
import org.koin.androidx.viewmodel.ext.android.viewModel

class PostDetailsFragment : Fragment() {
    private val vm: PostDetailsViewModel by viewModel()
    val args: PostDetailsFragmentArgs by navArgs()

    private lateinit var postTitleTextView: TextView
    private lateinit var postAuthorTextView: TextView
    private lateinit var postContentTextView: TextView

    private lateinit var commentsRecyclerView: RecyclerView
    private lateinit var adapter: CommentAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_post_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val thisId = args.id
        vm.id = thisId

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
    }

    private fun initAdapter() {
        adapter = CommentAdapter(layoutInflater)
        adapter.listener = ClickListener {

        }
    }

    private fun initRecycler() {
        val currentContext = context ?: return

        commentsRecyclerView.adapter = adapter
        commentsRecyclerView.layoutManager = LinearLayoutManager(currentContext)

        val spaceItemDecoration =
            SpaceItemDecoration(verticalSpaceInDp = 8, horizontalSpaceInDp = 16)
        commentsRecyclerView.addItemDecoration(spaceItemDecoration)
    }

    private fun initObservers() {
        vm.postDetailsLiveData.observe(viewLifecycleOwner) {
            postTitleTextView.text = it.title
            postAuthorTextView.text = "Firstname Lastname"
            postContentTextView.text = it.body
        }
        vm.commentsLiveData.observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
    }
}