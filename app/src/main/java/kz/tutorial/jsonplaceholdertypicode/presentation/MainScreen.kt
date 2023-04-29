package kz.tutorial.jsonplaceholdertypicode.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun MainScreen(
    personName: String,
    onPersonNameChange: () -> Unit,
) {
    MaterialTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GreetWorldAndPersonIntroduction(personName = personName)
            Button(onClick = onPersonNameChange) {
                Text("Change")
            }
        }
    }
}

@Composable
fun GreetingText() {
    Text(text = "Hello World!")
}

@Composable
fun GreetWorldAndPersonIntroduction(
    personName: String,
) {
    GreetingText()
    Text(text = "My name is $personName")
}