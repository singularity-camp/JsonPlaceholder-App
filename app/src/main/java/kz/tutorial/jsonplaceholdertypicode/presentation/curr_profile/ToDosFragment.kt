package kz.tutorial.jsonplaceholdertypicode.presentation.curr_profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.presentation.posts.PostAdapter
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.SpaceItemDecoration
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class ToDosFragment : Fragment() {
    private val vm : ToDosViewModel by viewModel {
        parametersOf(args.userId)
    }

    private val args : ToDosFragmentArgs by navArgs()

    lateinit var rvTodos: RecyclerView

    lateinit var adapter: TodosAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_to_dos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViews(view)
        initAdapter()
        initRecycler()
        initObservers()
    }

    private fun initViews(view: View) {
        rvTodos = view.findViewById(R.id.rv_todos)
    }

    private fun initAdapter() {
        adapter = TodosAdapter(layoutInflater)
    }

    private fun initRecycler() {
        val currentContext = context ?: return

        rvTodos.adapter = adapter
        rvTodos.layoutManager = LinearLayoutManager(currentContext)

        val spaceItemDecoration =
            SpaceItemDecoration(verticalSpaceInDp = 8, horizontalSpaceInDp = 16)
        rvTodos.addItemDecoration(spaceItemDecoration)
    }

    private fun initObservers() {
        vm.todosLiveData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

}