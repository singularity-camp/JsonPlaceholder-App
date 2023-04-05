package kz.tutorial.jsonplaceholdertypicode.presentation.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.domain.models.User
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.SpaceItemDecoration
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.extensions.startEmail
import org.koin.androidx.viewmodel.ext.android.viewModel

class UsersFragment : Fragment() {

    val viewModel: UsersFragmentViewmodel by viewModel()

    lateinit var rvUsers: RecyclerView

    lateinit var adapter: UsersAdapter

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
        with(view) {
            rvUsers = findViewById(R.id.rv_users)
        }
    }

    private fun initAdapter() {
        adapter = UsersAdapter(
            layoutInflater = layoutInflater,
            onUserClick = this::onUserClick,
            onEmailClick = this::onEmailClick
        )
    }

    private fun onUserClick(userId: Int) {
        findNavController().navigate(UsersFragmentDirections.actionUsersFragmentToUserProfileFragment(userId = userId))
    }

    private fun onEmailClick(email: String) {
        context?.startEmail(email)
    }

    private fun setupRecyclerView() {
        rvUsers.adapter = adapter
        rvUsers.layoutManager = LinearLayoutManager(context)

        val spaceItemDecoration =
            SpaceItemDecoration(verticalSpaceInDp = 8, horizontalSpaceInDp = 16)
        rvUsers.addItemDecoration(spaceItemDecoration)
    }

    private fun initObservers() {
        viewModel.usersLiveData.observe(viewLifecycleOwner) { onUsersUpdated(it) }

    }

    private fun onUsersUpdated(users: List<User>) {
        adapter.submitList(users)
    }

}