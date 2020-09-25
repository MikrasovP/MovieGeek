package demo.movie.app.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import demo.movie.app.di.discover.modules.DiscoverFragmentBuildersModule
import demo.movie.app.di.discover.modules.PresentersModule
import demo.movie.app.di.discover.modules.RepoModule
import demo.movie.app.di.discover.modules.SchedulerProviderModule
import demo.movie.app.di.scopes.DiscoverScope
import demo.movie.app.ui.detail.MovieDetailActivity
import demo.movie.app.ui.discover.DiscoverActivity

@Module
abstract class ActivityBuildersModule {

    @DiscoverScope
    @ContributesAndroidInjector(
        modules = [
            DiscoverFragmentBuildersModule::class,
            PresentersModule::class,
            RepoModule::class,
            SchedulerProviderModule::class
        ]
    )
    abstract fun contributeDiscoverActivity(): DiscoverActivity

    @DiscoverScope
    @ContributesAndroidInjector(
        modules = [
            PresentersModule::class,
            RepoModule::class,
            SchedulerProviderModule::class,
        ]
    )
    abstract fun contributeMovieDetailActivity(): MovieDetailActivity

}