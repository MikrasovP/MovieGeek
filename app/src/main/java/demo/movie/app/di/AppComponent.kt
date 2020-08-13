package demo.movie.app.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import demo.movie.app.ui.BaseApp

@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBuildersModule::class
    ]
)
interface AppComponent : AndroidInjector<BaseApp> {


    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }
}