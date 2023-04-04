package kz.tutorial.jsonplaceholdertypicode.presentation.albums

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.SpaceItemDecoration
import org.koin.androidx.viewmodel.ext.android.viewModel

class AlbumsFragment : Fragment() {

    private val vm: AlbumsViewModel by viewModel()
    private lateinit var rvAlbums: RecyclerView
    private lateinit var adapter: AlbumsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vm
        return inflater.inflate(R.layout.fragment_albums, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        initAdapter()
        initRecycler()
        initObservers()
    }

    private fun initViews(view: View) {
        rvAlbums = view.findViewById(R.id.rv_albums)
    }

    private fun initAdapter() {
        adapter = AlbumsAdapter(
            layoutInflater,
            onAlbumClick = this::onAlbumClick,
            onUserClick = this::onUserClick
        )
    }

    private fun onAlbumClick(albumId: Int) {}

    private fun onUserClick(userId: Int) {}

    private fun initRecycler() {
        rvAlbums.adapter = adapter
        rvAlbums.layoutManager = LinearLayoutManager(context ?: return)

        val spaceItemDecoration =
            SpaceItemDecoration(verticalSpaceInDp = 8, horizontalSpaceInDp = 16)
        rvAlbums.addItemDecoration(spaceItemDecoration)
    }

    private fun initObservers() {
        vm.albums.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }
}