package demo.movie.app.ui.discover

import demo.movie.app.ui.mvp.MvpPresenter
import demo.movie.app.ui.mvp.MvpView

interface DiscoverContract {

    interface DiscoverView : MvpView {

    }

    interface DiscoverPresenter : MvpPresenter<DiscoverView>{

    }
}