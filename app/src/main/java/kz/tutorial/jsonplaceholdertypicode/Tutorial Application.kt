package kz.tutorial.jsonplaceholdertypicode

import android.app.Application
import timber.log.Timber

class TutorialApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initTimber()
    }

    private fun initTimber() {
        Timber.plant(Timber.DebugTree())
    }

}