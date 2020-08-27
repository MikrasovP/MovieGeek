package demo.movie.app.ui.discover.tv

import demo.movie.app.model.dto.movie.MoviePreviewDto
import demo.movie.app.ui.mvp.MvpPresenter
import demo.movie.app.ui.mvp.MvpView

interface TvContract {

    interface TvView : MvpView {
        fun showPopular(popularMovieList: List<MoviePreviewDto>)

        fun showTrending(trendingMovieList: List<MoviePreviewDto>)

        fun showTopRated(topRatedMovieList: List<MoviePreviewDto>)

        fun showLoadError()

        fun showLoadingProgressBar()

        fun showReloadError()
    }

    interface TvPresenter : MvpPresenter<TvView>

}