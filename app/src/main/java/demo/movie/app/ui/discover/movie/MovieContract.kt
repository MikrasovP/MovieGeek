package demo.movie.app.ui.discover.movie

import demo.movie.app.model.dto.MoviePreviewDto
import demo.movie.app.ui.mvp.MvpPresenter
import demo.movie.app.ui.mvp.MvpView

interface MovieContract {

    interface MovieView : MvpView{
        fun showPopular(popularMovieList: List<MoviePreviewDto>)

        fun showTrending(trendingMovieList: List<MoviePreviewDto>)

        fun showTopRated(topRatedMovieList: List<MoviePreviewDto>)

        fun showLoadError()

        fun showLoadingProgressBar()

        fun showReloadError()

        fun showMovieDetail(movie: MoviePreviewDto)
    }

    interface MoviePresenter : MvpPresenter<MovieView>

}