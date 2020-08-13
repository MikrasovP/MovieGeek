package demo.movie.app.ui.discover.movie

import demo.movie.app.ui.mvp.MvpPresenter
import demo.movie.app.ui.mvp.MvpView

interface MovieContract {

    interface MovieView : MvpView

    interface MoviePresenter : MvpPresenter<MovieView>

}