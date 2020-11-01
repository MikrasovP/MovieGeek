package demo.movie.app.ui.discover.movie

import demo.movie.app.model.dto.movie.MoviePreviewDto
import demo.movie.app.ui.mvp.MvpPresenter
import demo.movie.app.ui.mvp.MvpView

interface MovieContract {

    interface MovieView : MvpView {

        fun setPopular(popularMovieList: List<MoviePreviewDto>)

        fun setTrending(trendingMovieList: List<MoviePreviewDto>)

        fun setTopRated(topRatedMovieList: List<MoviePreviewDto>)

        fun showLoadError()

        fun showLoadingProgressBar()

        fun showReloadError()

        fun showData()

        fun showMovieDetail(movie: MoviePreviewDto)
    }

    interface MoviePresenter : MvpPresenter<MovieView> {

        fun getAllData()

        fun refreshAllData()
    }

}