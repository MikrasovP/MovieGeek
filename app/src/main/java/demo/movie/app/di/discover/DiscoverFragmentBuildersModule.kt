package demo.movie.app.di.discover

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import demo.movie.app.di.ImageLoadModule
import demo.movie.app.di.scopes.DiscoverScope
import demo.movie.app.model.dto.movie.MoviePreviewDto
import demo.movie.app.ui.discover.movie.MovieContract
import demo.movie.app.ui.discover.movie.MovieFragment
import demo.movie.app.ui.discover.movie.MoviePresenter
import demo.movie.app.ui.discover.profile.ProfileFragment
import demo.movie.app.ui.discover.recycler.adapters.AdapterProvider
import demo.movie.app.ui.discover.recycler.adapters.BaseAdapterProvider
import demo.movie.app.ui.discover.tv.TvFragment

@Module
abstract class DiscoverFragmentBuildersModule {

    @DiscoverScope
    @Binds
    abstract fun bindMoviePresenter(moviePresenter: MoviePresenter): MovieContract.MoviePresenter

    @DiscoverScope
    @Binds
    abstract fun bindAdapterProvider(adapterProvider: AdapterProvider): BaseAdapterProvider


    @ContributesAndroidInjector()
    abstract fun contributeMovieFragment(): MovieFragment


    @ContributesAndroidInjector
    abstract fun contributeTvFragment(): TvFragment


    @ContributesAndroidInjector
    abstract fun contributeProfileFragment(): ProfileFragment
}