package demo.movie.app.di.discover.modules

import dagger.Binds
import dagger.Module
import demo.movie.app.di.scopes.DiscoverScope
import demo.movie.app.ui.detail.movie.MovieDetailContract
import demo.movie.app.ui.detail.movie.MovieDetailPresenter
import demo.movie.app.ui.detail.tv.TvDetailContract
import demo.movie.app.ui.detail.tv.TvDetailPresenter
import demo.movie.app.ui.discover.movie.MovieContract
import demo.movie.app.ui.discover.movie.MoviePresenter
import demo.movie.app.ui.discover.tv.TvContract
import demo.movie.app.ui.discover.tv.TvPresenter

@Module
abstract class PresentersModule {
    @DiscoverScope
    @Binds
    abstract fun bindMoviePresenter(moviePresenter: MoviePresenter): MovieContract.MoviePresenter

    @DiscoverScope
    @Binds
    abstract fun bindTvPresenter(tvPresenter: TvPresenter): TvContract.TvPresenter

    @DiscoverScope
    @Binds
    abstract fun bindMovieDetailPresenter(presenter: MovieDetailPresenter): MovieDetailContract.Presenter

    @DiscoverScope
    @Binds
    abstract fun bindTvDetailPresenter(presenter: TvDetailPresenter): TvDetailContract.Presenter
}