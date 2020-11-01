package demo.movie.app.ui.detail.movie

import demo.movie.app.model.dto.movie.MovieDetailDto
import demo.movie.app.model.dto.movie.MoviePreviewDto
import demo.movie.app.ui.mvp.MvpPresenter
import demo.movie.app.ui.mvp.MvpView

interface MovieDetailContract {

    interface View : MvpView {
        fun showPreviewData(moviePreview: MoviePreviewDto)

        fun showFullData(movieDetail: MovieDetailDto)
    }

    interface Presenter : MvpPresenter<View> {
        fun setMoviePreviewAndUpdateDetails(moviePreview: MoviePreviewDto)
    }

}