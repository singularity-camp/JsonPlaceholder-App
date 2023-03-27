package kz.tutorial.jsonplaceholdertypicode.presentation.albums.photos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.domain.models.Album
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.SpaceItemDecoration
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class PhotosFragment : Fragment() {
    private val args: PhotosFragmentArgs by navArgs()
    private val vmPhotos: PhotosViewModel by viewModel {
        parametersOf(args.albumId)
    }

    private lateinit var tvAlbumName: TextView
    private lateinit var tvUserName: TextView
    private lateinit var ivSelector: ImageButton
    private lateinit var rvPhotos: RecyclerView
    private lateinit var rvAdapter: PhotosAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_photos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViews(view)
        initLayoutSelector()
        initAdapter()
        initRecycler()
        initObservers()
    }

    private fun initViews(view: View) {
        tvAlbumName = view.findViewById(R.id.photos_tv_album_name)
        tvUserName = view.findViewById(R.id.photos_tv_username)
        ivSelector = view.findViewById(R.id.photos_iv_selector)
        rvPhotos = view.findViewById(R.id.photos_rv_photos)
    }

    private fun initLayoutSelector() {
        vmPhotos.changeSelectorBackground()

        ivSelector.setOnClickListener {
            vmPhotos.changeSelectorBackground()
            vmPhotos.setLayoutManager(context)
        }
    }

    private fun initAdapter() {
        rvAdapter = PhotosAdapter(layoutInflater)
    }

    private fun initRecycler() {
        rvPhotos.adapter = rvAdapter
        vmPhotos.setLayoutManager(context)

        val spaceItemDecoration =
            SpaceItemDecoration(verticalSpaceInDp = 8, horizontalSpaceInDp = 16)
        rvPhotos.addItemDecoration(spaceItemDecoration)
    }

    private fun initObservers() {
        vmPhotos.photos.observe(viewLifecycleOwner) {
            rvAdapter.setData(it)
        }

        vmPhotos.album.observe(viewLifecycleOwner) {
            onAlbumUpdated(it)
        }

        vmPhotos.rvLayoutState.observe(viewLifecycleOwner) {
            rvPhotos.layoutManager = it
        }

        vmPhotos.selectorBackground.observe(viewLifecycleOwner) {
            ivSelector.setBackgroundResource(it)
        }
    }

    private fun onAlbumUpdated(album: Album) {
        tvAlbumName.text = album.title
        tvUserName.text = album.username
    }
}