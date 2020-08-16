package demo.movie.app.di.discover

import dagger.Module
import dagger.android.ContributesAndroidInjector
import demo.movie.app.ui.discover.movie.MovieFragment
import demo.movie.app.ui.discover.profile.ProfileFragment
import demo.movie.app.ui.discover.tv.TvFragment

@Module
abstract class DiscoverFragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeMovieFragment(): MovieFragment

    @ContributesAndroidInjector
    abstract fun contributeTvFragment(): TvFragment

    @ContributesAndroidInjector
    abstract fun contributeProfileFragment() : ProfileFragment
}