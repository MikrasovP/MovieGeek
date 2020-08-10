package demo.movie.app.ui.discover

import demo.movie.app.ui.mvp.MvpView
import demo.movie.app.ui.mvp.PresenterBase

class DiscoverPresenter : PresenterBase<DiscoverContract.DiscoverView>(), DiscoverContract.DiscoverPresenter {
    override fun viewIsReady() {

    }

    override fun destroy() {
        TODO("Not yet implemented")
    }
}