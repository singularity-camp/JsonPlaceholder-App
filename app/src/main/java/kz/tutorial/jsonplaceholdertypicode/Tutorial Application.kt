package kz.tutorial.jsonplaceholdertypicode

import android.app.Application
import kz.tutorial.jsonplaceholdertypicode.di.networkModule
import org.koin.core.context.startKoin
import timber.log.Timber

class TutorialApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initTimber()
        startKoin {
            modules(networkModule)
        }
    }

    private fun initTimber() {
        Timber.plant(Timber.DebugTree())
    }

}