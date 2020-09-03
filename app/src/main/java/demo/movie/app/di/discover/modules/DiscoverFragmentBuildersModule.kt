package demo.movie.app.di.discover.modules

import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import demo.movie.app.di.scopes.DiscoverScope
import demo.movie.app.ui.discover.movie.MovieFragment
import demo.movie.app.ui.discover.profile.ProfileFragment
import demo.movie.app.ui.discover.recycler.adapters.AdapterProvider
import demo.movie.app.ui.discover.recycler.adapters.BaseAdapterProvider
import demo.movie.app.ui.discover.tv.TvFragment

@Module
abstract class DiscoverFragmentBuildersModule {

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