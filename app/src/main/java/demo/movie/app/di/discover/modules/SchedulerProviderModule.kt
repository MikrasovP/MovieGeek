package demo.movie.app.di.discover.modules

import dagger.Binds
import dagger.Module
import demo.movie.app.di.scopes.DiscoverScope
import demo.movie.app.util.rx.BaseSchedulerProvider
import demo.movie.app.util.rx.SchedulerProvider

@Module
abstract class SchedulerProviderModule {

    @DiscoverScope
    @Binds
    abstract fun bindSchedulerProvider(schedulerProvider: SchedulerProvider): BaseSchedulerProvider

}