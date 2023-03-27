package kz.tutorial.jsonplaceholdertypicode.presentation.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kz.tutorial.jsonplaceholdertypicode.R

class UsersFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_placeholder, container, false)
        //TODO: По сути тут ничего сложного.
        // Здесь вам просто нужно запустить запрос на https://jsonplaceholder.typicode.com/users
        // Моделька у вас уже есть
        // Дальше вам нужно просто создать экран отображения пользователей по фигме и нашей архитектуре
        //Рекомендую идти снизу вверх по древу зависимостей
        //Также, не забываем про клик на имейл

        //TODO: Советую попробовать и сделать доп задание:
        //1: Создать отдельную модельку для отображения только той информации
        // которая изображена в списке и назвать её UserShort.
        // Тем самым вам конечно нужно будет создать отдельный Use Case, метод в репозитории итд
    }

}