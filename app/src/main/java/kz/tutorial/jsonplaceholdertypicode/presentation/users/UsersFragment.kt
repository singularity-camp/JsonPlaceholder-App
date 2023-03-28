package kz.tutorial.jsonplaceholdertypicode.presentation.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.SpaceItemDecoration
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.extensions.startEmail
import org.koin.androidx.viewmodel.ext.android.viewModel

class UsersFragment : Fragment() {

    val vmUsers: UsersViewModel by viewModel()

    private lateinit var rvUsers: RecyclerView
    private lateinit var rvAdapter: UsersAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_users, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews(view)
        initAdapter()
        setupRecyclerView()
        initObservers()
    }

    private fun initViews(view: View) {
        rvUsers = view.findViewById(R.id.users_rv_users)
    }

    private fun initAdapter() {
        rvAdapter = UsersAdapter(layoutInflater = layoutInflater, onEmailClick = this::onEmailClick)
    }

    private fun onEmailClick(email: String) {
        context?.startEmail(email)
    }

    private fun setupRecyclerView() {
        val currentContext = context ?: return
        rvUsers.adapter = rvAdapter
        rvUsers.layoutManager = LinearLayoutManager(currentContext)

        val spaceItemDecoration =
            SpaceItemDecoration(verticalSpaceInDp = 8, horizontalSpaceInDp = 16)
        rvUsers.addItemDecoration(spaceItemDecoration)
    }

    private fun initObservers() {

    }
}