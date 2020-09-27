package demo.movie.app.ui.detail

import android.util.Log
import demo.movie.app.model.dto.movie.MovieDetailDto
import demo.movie.app.model.dto.movie.MoviePreviewDto
import demo.movie.app.model.repo.movies.BaseMoviesRepo
import demo.movie.app.ui.mvp.PresenterBase
import demo.movie.app.util.rx.BaseSchedulerProvider
import javax.inject.Inject

class MovieDetailPresenter @Inject constructor(
    var moviesRepo: BaseMoviesRepo,
    var schedulerProvider: BaseSchedulerProvider,
) :
    MovieDetailContract.Presenter,
    PresenterBase<MovieDetailContract.View>() {

    companion object {
        private const val TAG = "MovieDetailPresenter"
    }

    override fun setMoviePreviewAndUpdateDetails(moviePreview: MoviePreviewDto) {
        moviesRepo.getMovieDetails(moviePreview.id)
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .subscribe({
                view?.showFullData(it)
            }, {
                Log.e(TAG, "setMoviePreviewAndUpdateDetails: ${it.message}", it)
            })
    }


    override fun viewIsReady() {

    }

    override fun destroy() {

    }


}