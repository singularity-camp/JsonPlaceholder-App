package kz.tutorial.jsonplaceholdertypicode.presentation.users.todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.SpaceItemDecoration
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class ToDoFragment : Fragment() {
    private val args: ToDoFragmentArgs by navArgs()
    private val vmToDo: ToDoViewModel by viewModel {
        parametersOf(args.userId)
    }

    private lateinit var rvToDo: RecyclerView
    private lateinit var rvAdapter: ToDoAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_todo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews(view)
        initAdapter()
        setupRecyclerView()
        initObservers()
    }

    private fun initViews(view: View) {
        rvToDo = view.findViewById(R.id.todo_rv_todos)
    }

    private fun initAdapter() {
        rvAdapter = ToDoAdapter(layoutInflater = layoutInflater)
    }

    private fun setupRecyclerView() {
        val currentContext = context ?: return
        rvToDo.adapter = rvAdapter
        rvToDo.layoutManager = LinearLayoutManager(currentContext)

        val spaceItemDecoration =
            SpaceItemDecoration(verticalSpaceInDp = 8, horizontalSpaceInDp = 16)
        rvToDo.addItemDecoration(spaceItemDecoration)
    }

    private fun initObservers() {
        vmToDo.toDoList.observe(viewLifecycleOwner) {
            rvAdapter.submitList(it)
        }
    }
}