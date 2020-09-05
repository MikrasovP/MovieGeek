package demo.movie.app.ui.detail

import demo.movie.app.model.dto.movie.MovieDetailDto
import demo.movie.app.ui.mvp.MvpPresenter
import demo.movie.app.ui.mvp.MvpView

interface MovieDetailContract {

    interface View : MvpView{
        fun showData(movie: MovieDetailDto)
    }

    interface Presenter : MvpPresenter<View> {
        fun getMovieDetail(id: Int)
    }

}