package kz.tutorial.jsonplaceholdertypicode.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val personName = remember {
                mutableStateOf("Ulpan")
            }

            MainScreen(
                personName = personName.value,
                onPersonNameChange = { personName.value = "Dulat" }
            )

        }
    }
}