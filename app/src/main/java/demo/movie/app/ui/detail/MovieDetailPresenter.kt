package demo.movie.app.ui.detail

import demo.movie.app.ui.mvp.PresenterBase
import javax.inject.Inject

class MovieDetailPresenter @Inject constructor() :
    MovieDetailContract.Presenter,
    PresenterBase<MovieDetailContract.View>() {

    override fun getMovieDetail(id: Int) {
        TODO("Not yet implemented")
    }

    override fun viewIsReady() {
        TODO("Not yet implemented")
    }

    override fun destroy() {
        TODO("Not yet implemented")
    }


}