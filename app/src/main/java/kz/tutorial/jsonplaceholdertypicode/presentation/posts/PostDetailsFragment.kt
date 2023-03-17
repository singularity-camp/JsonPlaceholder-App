package kz.tutorial.jsonplaceholdertypicode.presentation.posts

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import kz.tutorial.jsonplaceholdertypicode.R
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class PostDetailsFragment : Fragment() {

    private val vm: PostDetailsViewModel by viewModel()
    val args: PostDetailsFragmentArgs by navArgs()

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

        vm.currPostLiveData.observe(viewLifecycleOwner) {
            Timber.e(it.toString())
        }

    }

}