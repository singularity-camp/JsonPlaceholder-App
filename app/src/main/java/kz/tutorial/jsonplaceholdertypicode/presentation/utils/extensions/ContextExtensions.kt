package kz.tutorial.jsonplaceholdertypicode.presentation.utils.extensions

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


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

fun Context.openLink(link : String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://${link}"))
    startActivity(intent)
}

fun Context.showMap(lat: String, lng: String) {
    val geoIntent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:$lat,$lng"))
    startActivity(geoIntent)
}

