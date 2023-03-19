package kz.tutorial.jsonplaceholdertypicode.presentation.albums

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import kz.tutorial.jsonplaceholdertypicode.R

class AlbumsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_placeholder, container, false)

        //FAQ: Как пользоваться Glide-ом

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Вьюшка в которую мы будем загружать изображение
        //После того как поймете как работать с глайдом, уберите её из этого экрана и код ниже
        val ivExample: ImageView = view.findViewById(R.id.iv_example)

        //Можете использовать разные весрии Glide.with(). Нажмите внутри скобок Сtrl + P и поймете о чем я
        //Можно даже саму ImageView передать
        Glide.with(this)
                //в load() передаем ссылку нашего изображения
            .load("https://media.wired.co.uk/photos/606d9b367aff197af7c72a2f/4:3/w_2668,h_2001,c_limit/wired-uk-android-tips-1.jpg")
                //Указываем наш ImageView в который мы хотим загрузить изображение
            .into(ivExample)
        //Всё
    }

}