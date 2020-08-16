package demo.movie.app.ui.discover.profile

import demo.movie.app.ui.mvp.MvpPresenter
import demo.movie.app.ui.mvp.MvpView

interface ProfileContract {

    interface ProfileView : MvpView

    interface ProfilePresenter : MvpPresenter<ProfileView>

}