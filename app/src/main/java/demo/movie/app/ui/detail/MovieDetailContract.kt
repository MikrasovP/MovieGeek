package demo.movie.app.ui.detail

import demo.movie.app.ui.mvp.MvpPresenter
import demo.movie.app.ui.mvp.MvpView

interface MovieDetailContract {

    interface MovieDetailView : MvpView{
        fun showData()
    }

    interface MovieDetailPresenter : MvpPresenter<MovieDetailView> {
        fun getMovieDetail(id: Int)
    }

}