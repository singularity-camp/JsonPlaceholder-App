package kz.tutorial.jsonplaceholdertypicode.presentation.albums.photos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.SpaceItemDecoration
import org.koin.androidx.viewmodel.ext.android.viewModel

class PhotosFragment : Fragment() {
    private val args: PhotosFragmentArgs by navArgs()
    private val vmPhotos: PhotosViewModel by viewModel()

    private lateinit var tvAlbumName: TextView
    private lateinit var tvUserName: TextView
    private lateinit var ivSelector: ImageView
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
        initAdapter()
        initRecycler()
        initContent()
        initObservers()
    }

    private fun initViews(view: View) {
        tvAlbumName = view.findViewById(R.id.photos_tv_album_name)
        tvUserName = view.findViewById(R.id.photos_tv_username)
        ivSelector = view.findViewById(R.id.photos_iv_selector)
        rvPhotos = view.findViewById(R.id.photos_rv_photos)
    }

    private fun initAdapter() {
        rvAdapter = PhotosAdapter(layoutInflater)
    }

    private fun initRecycler() {
        val currentContext = context ?: return

        rvPhotos.adapter = rvAdapter
        rvPhotos.layoutManager = LinearLayoutManager(currentContext)

        val spaceItemDecoration =
            SpaceItemDecoration(verticalSpaceInDp = 8, horizontalSpaceInDp = 16)
        rvPhotos.addItemDecoration(spaceItemDecoration)
    }

    private fun initContent() {
        vmPhotos.getPhotos(args.albumId)
    }

    private fun initObservers() {
        vmPhotos.photos.observe(viewLifecycleOwner) {
            rvAdapter.setData(it)
        }

        vmPhotos.album.observe(viewLifecycleOwner) {
            tvAlbumName.text = it.title
        }
    }
}