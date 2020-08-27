package demo.movie.app.ui

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import demo.movie.app.di.DaggerAppComponent

class BaseApp : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.builder().application(this).build()
}