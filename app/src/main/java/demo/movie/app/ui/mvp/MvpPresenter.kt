package demo.movie.app.ui.mvp

interface MvpPresenter<V : MvpView?> {
    fun attachView(view: V)

    fun viewIsReady()

    fun detachView()

    fun destroy()
}