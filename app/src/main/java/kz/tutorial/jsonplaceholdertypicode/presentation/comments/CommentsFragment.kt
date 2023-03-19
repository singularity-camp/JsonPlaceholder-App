package kz.tutorial.jsonplaceholdertypicode.presentation.comments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.domain.models.Comment
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.SpaceItemDecoration
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.extensions.startEmail
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class CommentsFragment : Fragment() {

    lateinit var rvComments: RecyclerView

    val args: CommentsFragmentArgs by navArgs()
    val viewModel: CommentsViewModel by viewModel {
        //Передаем пост айди во вьюмодел. Настроили передачу параметра в di.viewModelModule

        //Мы можем так делать потому, что поля инициализируются по очереди сверху вниз.
        //То есть даже если это было бы не lazy инициализация, к этому моменту args уже был бы создан и мы могли работать с ним
        parametersOf(args.postId)
    }

    lateinit var adapter: CommentsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Просто "пользуемся" чтобы инициализировать viewModel -> Запускаем init{} во
        // viewModel -> запускаем скачивание данных. Можете проверить через логи
        viewModel

        return inflater.inflate(R.layout.fragment_comments, container, false)
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
            rvComments = findViewById(R.id.rv_comments)
        }
    }

    private fun initAdapter() {
        adapter = CommentsAdapter(
            layoutInflater = layoutInflater,
            onEmailClick = this::onEmailClick
        )
    }

    private fun onEmailClick(email: String) {
        //Проверьте startEmail чтобы посмотреть что происходит под капотом
        context?.startEmail(email)
    }

    private fun setupRecyclerView() {
        rvComments.adapter = adapter
        rvComments.layoutManager = LinearLayoutManager(context)

        val spaceItemDecoration =
            SpaceItemDecoration(verticalSpaceInDp = 8, horizontalSpaceInDp = 16)
        rvComments.addItemDecoration(spaceItemDecoration)
    }

    private fun initObservers() {
        viewModel.comments.observe(viewLifecycleOwner) { onCommentsUpdated(it) }

    }

    private fun onCommentsUpdated(comments: List<Comment>) {
        adapter.submitList(comments)
    }
}