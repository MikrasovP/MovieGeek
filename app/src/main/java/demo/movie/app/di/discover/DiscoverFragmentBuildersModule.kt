package demo.movie.app.di.discover

import dagger.Binds
import dagger.BindsInstance
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import demo.movie.app.ui.discover.movie.MovieContract
import demo.movie.app.ui.discover.movie.MovieFragment
import demo.movie.app.ui.discover.movie.MoviePresenter
import demo.movie.app.ui.discover.profile.ProfileFragment
import demo.movie.app.ui.discover.tv.TvFragment

@Module
abstract class DiscoverFragmentBuildersModule {

    companion object {
        @Provides
        fun providesMoviePresenter() = MoviePresenter()
    }

    @ContributesAndroidInjector
    abstract fun contributeMovieFragment(): MovieFragment

    @Binds
    abstract fun provideMoviePresenter(moviePresenter: MoviePresenter): MovieContract.MoviePresenter

    @ContributesAndroidInjector
    abstract fun contributeTvFragment(): TvFragment

    @ContributesAndroidInjector
    abstract fun contributeProfileFragment(): ProfileFragment
}