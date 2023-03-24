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

    private val vmAlbums: AlbumsViewModel by viewModel()

    private lateinit var rvAlbums: RecyclerView
    private lateinit var rvAdapter: AlbumsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_album, container, false)

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
        initViews(view)
        initAdapter()
        initRecycler()
        initObservers()
    }

    private fun initViews(view: View) {
        rvAlbums = view.findViewById(R.id.rv_albums)
    }

    private fun initAdapter() {
        rvAdapter = AlbumsAdapter(layoutInflater)
    }

    private fun initRecycler() {
        val currentContext = context ?: return

        rvAlbums.adapter = rvAdapter
        rvAlbums.layoutManager = LinearLayoutManager(currentContext)

        val spaceItemDecoration =
            SpaceItemDecoration(verticalSpaceInDp = 8, horizontalSpaceInDp = 16)
        rvAlbums.addItemDecoration(spaceItemDecoration)
    }

    private fun initObservers() {
        vmAlbums.albums.observe(viewLifecycleOwner) {
            rvAdapter.setData(it)
        }
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        //FAQ: Как пользоваться Glide-ом
//
//        //Вьюшка в которую мы будем загружать изображение
//        //После того как поймете как работать с глайдом, уберите её из этого экрана и код ниже
//        val ivExample: ImageView = view.findViewById(R.id.iv_example)
//
//        //Можете использовать разные весрии Glide.with(). Нажмите внутри скобок Сtrl + P и поймете о чем я
//        //Можно даже саму ImageView передать
//        Glide.with(this)
//                //в load() передаем ссылку нашего изображения
//            .load("https://media.wired.co.uk/photos/606d9b367aff197af7c72a2f/4:3/w_2668,h_2001,c_limit/wired-uk-android-tips-1.jpg")
//                //Указываем наш ImageView в который мы хотим загрузить изображение
//            .into(ivExample)
//        //Всё
//    }

}