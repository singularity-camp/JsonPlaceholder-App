package kz.tutorial.jsonplaceholdertypicode.presentation.albums

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
import kz.tutorial.jsonplaceholdertypicode.presentation.comments.CommentsFragmentArgs
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.SpaceItemDecoration
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class AlbumPhotosFragment : Fragment() {

    val args: AlbumPhotosFragmentArgs by navArgs()
    private val vm: AlbumPhotosViewModel by viewModel{
        parametersOf(args.albumId)
    }

    lateinit var rvPhotos: RecyclerView
    private lateinit var tvAlbumName : TextView
    private lateinit var tvAlbumUsername : TextView

    lateinit var adapter: PhotosAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_album_photos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViews(view)
        initAdapter()
        initRecycler()
        initObservers()
    }

    private fun initViews(view: View) {
        rvPhotos = view.findViewById(R.id.rv_photos)
        tvAlbumName = view.findViewById(R.id.tv_album_name)
        tvAlbumUsername = view.findViewById(R.id.tv_username)
        tvAlbumName.text = args.albumId.toString()
    }

    private fun initAdapter() {
        adapter = PhotosAdapter(layoutInflater)
    }

    private fun initRecycler() {
        val currentContext = context ?: return

        rvPhotos.adapter = adapter
        rvPhotos.layoutManager = LinearLayoutManager(currentContext)

        val spaceItemDecoration =
            SpaceItemDecoration(verticalSpaceInDp = 8, horizontalSpaceInDp = 16)
        rvPhotos.addItemDecoration(spaceItemDecoration)
    }

    private fun initObservers() {
        vm.photosLiveData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }


}