package kz.tutorial.jsonplaceholdertypicode.presentation.posts.details

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
import kz.tutorial.jsonplaceholdertypicode.domain.models.Comment
import kz.tutorial.jsonplaceholdertypicode.domain.models.Post
import kz.tutorial.jsonplaceholdertypicode.domain.models.User
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.SpaceItemDecoration
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.extensions.startEmail
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class PostDetailsFragment : Fragment() {

    lateinit var tvAuthor: TextView
    lateinit var tvTitle: TextView
    lateinit var tvBody: TextView
    lateinit var tvShowAllComments: TextView
    lateinit var rvComments: RecyclerView

    val args: PostDetailsFragmentArgs by navArgs()
    val viewModel: PostDetailsViewModel by viewModel {
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

        return inflater.inflate(R.layout.fragment_post_details, container, false)
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
            tvAuthor = findViewById(R.id.tv_author)
            tvBody = findViewById(R.id.tv_body)
            tvTitle = findViewById(R.id.tv_title)
            tvShowAllComments = findViewById(R.id.tv_show_all)
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
        viewModel.post.observe(viewLifecycleOwner) { onPostUpdated(it) }
        viewModel.author.observe(viewLifecycleOwner) { onAuthorUpdated(it) }
        viewModel.comments.observe(viewLifecycleOwner) { onCommentsUpdated(it) }

    }

    private fun onPostUpdated(post: Post) {
        tvTitle.text = post.title
        tvBody.text = post.body
    }

    private fun onAuthorUpdated(author: User) {
        tvAuthor.text = author.name
    }

    private fun onCommentsUpdated(comments: List<Comment>) {
        adapter.submitList(comments)
    }
}