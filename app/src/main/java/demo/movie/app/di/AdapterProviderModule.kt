package demo.movie.app.di

import dagger.Binds
import dagger.Module
import demo.movie.app.di.scopes.DiscoverScope
import demo.movie.app.ui.recycler.adapters.AdapterProvider
import demo.movie.app.ui.recycler.adapters.BaseAdapterProvider

@Module
abstract class AdapterProviderModule {

    @DiscoverScope
    @Binds
    abstract fun bindAdapterProvider(adapterProvider: AdapterProvider): BaseAdapterProvider

}