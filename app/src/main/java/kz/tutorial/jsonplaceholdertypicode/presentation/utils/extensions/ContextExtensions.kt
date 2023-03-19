package kz.tutorial.jsonplaceholdertypicode.presentation.utils.extensions

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.annotation.StringRes

fun Context.showToast(msg: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, msg, length).show()
}

fun Context.showToast(@StringRes resId: Int, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, resId, length).show()
}

//Выводим в отдельный метод, чтобы легко переиспользовать эту функцию и заменить boilerplae код одной строкой
fun Context.startEmail(email: String) {
    val emailIntent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:$email"))

    //Checking if there is an app that can handle this intent
    startActivity(emailIntent)
}