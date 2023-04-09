package kz.tutorial.jsonplaceholdertypicode.presentation.users.todo

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.SpaceItemDecoration
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class ToDoFragment : Fragment() {
    private val args: ToDoFragmentArgs by navArgs()
    private val vm: ToDoViewModel by viewModel {
        parametersOf(args.userId)
    }
    private lateinit var rvTodos: RecyclerView
    private lateinit var adapter: ToDoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_todo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        initAdapter()
        initRecycler()
        initObservers()
    }

    private fun initViews(view: View) {
        rvTodos = view.findViewById(R.id.rv_tasks)

    }

    private fun initAdapter() {
        adapter = ToDoAdapter(layoutInflater = layoutInflater)
    }

    private fun initRecycler() {
        rvTodos.adapter = adapter
        rvTodos.layoutManager = LinearLayoutManager(context ?: return)

        val spaceItemDecoration =
            SpaceItemDecoration(verticalSpaceInDp = 8, horizontalSpaceInDp = 16)
        rvTodos.addItemDecoration(spaceItemDecoration)
    }

    private fun initObservers() {
        vm.todos.observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
    }
}