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
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.SpaceItemDecoration
import org.koin.androidx.viewmodel.ext.android.viewModel

class UsersFragment : Fragment() {

    private val vm: UsersViewModel by viewModel()
    private lateinit var rvUsers: RecyclerView
    private lateinit var adapter: UsersAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        vm
        return inflater.inflate(R.layout.fragment_users, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        initAdapter()
        initRecycler()
        initObservers()
    }

    private fun initViews(view: View) {
        rvUsers = view.findViewById(R.id.rv_users)
    }

    private fun initAdapter() {
        adapter = UsersAdapter(
            layoutInflater, onUserClick = this::onUserClick, onEmailClick = this::onEmailClick
        )
    }

    private fun onUserClick(userId: Int, username: String, fullname: String, email: String) {
        findNavController().navigate(
            UsersFragmentDirections.actionUsersFragmentToUserProfileFragment(
                userId,
                username,
                email,
                fullname
            )
        )
    }

    private fun onEmailClick(email: String) {}

    private fun initRecycler() {
        rvUsers.adapter = adapter
        rvUsers.layoutManager = LinearLayoutManager(context ?: return)

        val spaceItemDecoration =
            SpaceItemDecoration(verticalSpaceInDp = 8, horizontalSpaceInDp = 16)
        rvUsers.addItemDecoration(spaceItemDecoration)
    }

    private fun initObservers() {
        vm.users.observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
    }
}