package kz.tutorial.jsonplaceholdertypicode.presentation.albums

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.SpaceItemDecoration
import org.koin.androidx.viewmodel.ext.android.viewModel


class AlbumsFragment : Fragment() {

    private val vm: AlbumsViewmodel by viewModel()

    lateinit var rvAlbums: RecyclerView

    lateinit var adapter: AlbumAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_albums, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViews(view)
        initAdapter()
        initRecycler()
        initObservers()
    }

    private fun initViews(view: View) {
        rvAlbums = view.findViewById(R.id.rv_albums)
    }

    private fun initAdapter() {
        adapter = AlbumAdapter(layoutInflater,
        onAlbumClick = this::onAlbumClick,
        onUserClick = this::onUserClick,
        )
    }

    private fun onAlbumClick(albumId: Int) {
        findNavController().navigate(
            AlbumsFragmentDirections.actionAlbumsFragmentToAlbumPhotosFragment(albumId = albumId)
        )
    }

    private fun onUserClick(userId: Int) {
        ///
    }
    private fun initRecycler() {
        val currentContext = context ?: return

        rvAlbums.adapter = adapter
        rvAlbums.layoutManager = LinearLayoutManager(currentContext)

        val spaceItemDecoration =
            SpaceItemDecoration(verticalSpaceInDp = 8, horizontalSpaceInDp = 16)
        rvAlbums.addItemDecoration(spaceItemDecoration)
    }

    private fun initObservers() {
        vm.albumsLiveData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }


}