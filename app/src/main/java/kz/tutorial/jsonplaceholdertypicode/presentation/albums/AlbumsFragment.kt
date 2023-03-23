package kz.tutorial.jsonplaceholdertypicode.presentation.albums

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.domain.models.Album
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.SpaceItemDecoration
import org.koin.androidx.viewmodel.ext.android.viewModel

class AlbumsFragment : Fragment() {

    val viewModel: AlbumsViewModel by viewModel()

    lateinit var rvAlbums: RecyclerView

    lateinit var adapter: AlbumsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Просто "пользуемся" чтобы инициализировать viewModel -> Запускаем init{} во
        // viewModel -> запускаем скачивание данных. Можете проверить через логи
        viewModel
        return inflater.inflate(R.layout.fragment_albums, container, false)

        /*TODO: Вам нужно скачать список альбомов и показать его.
        Для упрощения задачи можете пока не показывать пользователя которому принадлежит

        Для решения этого вам надо добавить соответствующий запрос в MainApi
        Затем Создайте AlbumRepository и AlbumRepositoryImpl
        После этого Добавьте GetAlbumsUseCase
        Затем уже создайте AlbumsViewModel
        После этого добавьте инструкции в di. Сначала RepositoryModule
        (не забудьте, что вам нужно вернуть AlbumsRepository создав Albums RepositoryImpl)
        Затем создайте инструкции для UseCaseModule и ViewModelModule

        Затем можете засетапить либо AlbumsViewModel и написать логику его работы),
        либо создать UI (Layout, Fragment) и только потом ViewModel)


        После того как вы всё это выполните, можете добавить пользователя
        Для этого создайте дата класс AlbumsWithUser где будут лежать нужные поля
        Чтобы не сильно усложнять логику пропищите в GetAlbumsWithUserUseCase
        в ней запускайте запрос на альбомы, потом запрос на всех пользователей
        и используя два списка, создайте список объектов AlbumsWithUser
        (для каждого альбома ищете пользователя во втором списке
        и на основе этих двух элементов создаете нужный вам объект и добавляете в свой новый список)
        Далее обновляете ваш адаптер чтобы он принимал AlbumsWithUser, ну и пару других классов тоже)
        */
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
            rvAlbums = findViewById(R.id.rv_albums)
        }
    }

    private fun initAdapter() {
        adapter = AlbumsAdapter(
            layoutInflater = layoutInflater,
            onAlbumClick = this::onAlbumClick,
            onUserClick = this::onUserClick,
        )
    }

    private fun onAlbumClick(albumId: Int) {

    }

    private fun onUserClick(userId: Int) {

    }

    private fun setupRecyclerView() {
        rvAlbums.adapter = adapter
        rvAlbums.layoutManager = LinearLayoutManager(context)

        val spaceItemDecoration =
            SpaceItemDecoration(verticalSpaceInDp = 8, horizontalSpaceInDp = 16)
        rvAlbums.addItemDecoration(spaceItemDecoration)
    }

    private fun initObservers() {
        viewModel.albums.observe(viewLifecycleOwner) { onAlbumsUpdated(it) }

    }

    private fun onAlbumsUpdated(albums: List<Album>) {
        adapter.submitList(albums)
    }

}