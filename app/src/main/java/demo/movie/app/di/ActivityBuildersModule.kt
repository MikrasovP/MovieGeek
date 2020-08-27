package demo.movie.app.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import demo.movie.app.di.discover.DiscoverFragmentBuildersModule
import demo.movie.app.di.scopes.DiscoverScope
import demo.movie.app.ui.discover.DiscoverActivity

@Module
abstract class ActivityBuildersModule {

    @DiscoverScope
    @ContributesAndroidInjector(
        modules = [
            DiscoverFragmentBuildersModule::class,
            RepoModule::class
        ]
    )
    abstract fun contributeDiscoverActivity(): DiscoverActivity

}