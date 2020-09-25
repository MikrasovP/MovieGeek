package demo.movie.app.ui.detail

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

    private lateinit var movieDetail: MovieDetailDto

    override fun setMoviePreviewAndUpdateDetails(moviePreview: MoviePreviewDto) {
        if (moviePreview.id != movieDetail.id) {
            moviesRepo.getMovieDetails(moviePreview.id)
                .subscribeOn(schedulerProvider.ui())
                .observeOn(schedulerProvider.io())
                .subscribe {
                    movieDetail = it
                    view?.showFullData(movieDetail)
                }
        }
    }


    override fun viewIsReady() {

    }

    override fun destroy() {

    }


}