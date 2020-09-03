package demo.movie.app.ui.mvp

import android.util.Log

abstract class PresenterBase<V : MvpView?> : MvpPresenter<V> {

    companion object{
        private const val TAG = "PresenterBase"
    }

    var view: V? = null
        private set

    override fun attachView(view: V) {
        this.view = view
    }

    override fun detachView() {
        view = null
    }

    fun isViewAttached() = view != null
}