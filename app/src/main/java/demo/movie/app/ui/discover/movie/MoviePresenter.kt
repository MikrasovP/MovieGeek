package demo.movie.app.ui.discover.movie

import android.util.Log
import demo.movie.app.model.dto.movie.MoviesListsWrapper
import demo.movie.app.model.dto.movie.MoviesResponseResult
import demo.movie.app.model.repo.movies.BaseMoviesRepo
import demo.movie.app.ui.mvp.PresenterBase
import demo.movie.app.util.rx.BaseSchedulerProvider
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.functions.Function3
import javax.inject.Inject

class MoviePresenter @Inject constructor(
    var moviesRepo: BaseMoviesRepo,
    var schedulerProvider: BaseSchedulerProvider
) :
    PresenterBase<MovieContract.MovieView>(),
    MovieContract.MoviePresenter {

    companion object {
        private const val TAG = "MoviePresenter"
    }


    private var isDataLoaded = false


    override fun getAllData() {
        val topRatedMoviesObservable = moviesRepo.getTopRated()
        val popularMoviesObservable = moviesRepo.getPopular()
        val trendingMoviesObservable = moviesRepo.getTrendingPerDay()

        Observable.combineLatest(
            topRatedMoviesObservable,
            popularMoviesObservable,
            trendingMoviesObservable,
            Function3 { topRated: MoviesResponseResult,
                        popular: MoviesResponseResult,
                        trending: MoviesResponseResult ->
                MoviesListsWrapper(
                    topRatedMovies = topRated.results,
                    popularMovies = popular.results,
                    trendingMovies = trending.results
                )
            })
            .subscribeOn(schedulerProvider.io())
            .doOnSubscribe {
                view?.showLoadingProgressBar()
            }
            .observeOn(schedulerProvider.ui())
            .subscribe({
                onDataReceived(it)
            }, {
                view?.showLoadError()
                Log.e(TAG, "getAllData(): ", it)
            })


    }

    private fun onDataReceived(data: MoviesListsWrapper) {
        view?.setTopRated(data.topRatedMovies)
        view?.setPopular(data.popularMovies)
        view?.setTrending(data.trendingMovies)

        view?.showData()
        if (view != null)
            isDataLoaded = true
    }

    override fun refreshAllData() {
        TODO("Not yet implemented")
    }


    override fun viewIsReady() {
        if (!isDataLoaded)
            getAllData()
        else
            view?.showData()
    }

    override fun destroy() {
        TODO("Not yet implemented")
    }

}