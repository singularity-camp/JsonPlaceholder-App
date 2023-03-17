package kz.tutorial.jsonplaceholdertypicode.presentation.posts

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import kz.tutorial.jsonplaceholdertypicode.R
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class PostDetailsFragment : Fragment() {

    private val vm: PostDetailsViewModel by viewModel()
    val args: PostDetailsFragmentArgs by navArgs()

    private lateinit var tvTitle : TextView
    private lateinit var tvAuthor : TextView
    private lateinit var tvContent : TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_post_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val currId = args.id
        vm.userId = currId

        initViews(view)
        initObservers()

    }

    private fun initViews(view : View) {
        with(view) {
            tvTitle = findViewById(R.id.tv_title)
            tvAuthor = findViewById(R.id.tv_author)
            tvContent = findViewById(R.id.tv_content)
        }
    }

    private fun initObservers() {
        vm.currPostLiveData.observe(viewLifecycleOwner) {
            tvTitle.text = it.title
            tvAuthor.text = "By: ${it.userId}"
            tvContent.text = it.body
        }
    }

}