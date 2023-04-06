package kz.tutorial.jsonplaceholdertypicode.presentation.albums.photos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.SpaceItemDecoration
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class AlbumPhotosFragment : Fragment() {
    private val vm: AlbumPhotosViewModel by viewModel {
        parametersOf(args.albumId)
    }
    val args: AlbumPhotosFragmentArgs by navArgs()

    private lateinit var rvAlbumPhotos: RecyclerView
    private lateinit var tvPhotoAlbumName: TextView
    private lateinit var tvUsername: TextView
    private lateinit var ivSwitchLayout: ImageView
    private lateinit var adapter: AlbumPhotosAdapter
    private var isGridLayout = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        vm
        return inflater.inflate(R.layout.fragment_album_photos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        initAdapter()
        initRecycler()
        initObservers()
    }

    private fun initViews(view: View) {
        rvAlbumPhotos = view.findViewById(R.id.rv_photos)
        tvPhotoAlbumName = view.findViewById(R.id.tv_album_name)
        tvUsername = view.findViewById(R.id.tv_username)
        ivSwitchLayout = view.findViewById(R.id.btn_view_type)
        tvPhotoAlbumName.text = args.albumId.toString()

        ivSwitchLayout.setOnClickListener {
            isGridLayout = !isGridLayout
            if (isGridLayout) {
                ivSwitchLayout.setImageResource(R.drawable.ic_grid)
                rvAlbumPhotos.layoutManager = GridLayoutManager(context, 2)
            } else {
                ivSwitchLayout.setImageResource(R.drawable.ic_line)
                rvAlbumPhotos.layoutManager = LinearLayoutManager(context)
            }
        }
    }

    private fun initAdapter() {
        adapter = AlbumPhotosAdapter(layoutInflater)
    }

    private fun initRecycler() {
        rvAlbumPhotos.adapter = adapter
        rvAlbumPhotos.layoutManager = LinearLayoutManager(context ?: return)

        val spaceItemDecoration =
            SpaceItemDecoration(verticalSpaceInDp = 8, horizontalSpaceInDp = 16)
        rvAlbumPhotos.addItemDecoration(spaceItemDecoration)
    }

    private fun initObservers() {
        vm.albumPhotos.observe(viewLifecycleOwner) {
            adapter.setData(it)
        }

        vm.album.observe(viewLifecycleOwner) { album ->
            tvPhotoAlbumName.text = album.title
            tvUsername.text = album.username
        }
    }


}