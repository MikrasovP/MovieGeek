package demo.movie.app.ui.discover.tv

import demo.movie.app.ui.mvp.MvpPresenter
import demo.movie.app.ui.mvp.MvpView

interface TvContract {

    interface TvView : MvpView

    interface TvPresenter : MvpPresenter<TvView>

}