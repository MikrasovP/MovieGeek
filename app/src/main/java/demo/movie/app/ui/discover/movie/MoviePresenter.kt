package demo.movie.app.ui.discover.movie

import android.util.Log
import demo.movie.app.model.dto.movie.MoviesListsWrapper
import demo.movie.app.model.dto.movie.MoviesResponseResult
import demo.movie.app.model.repo.movies.BaseMoviesRepo
import demo.movie.app.ui.mvp.PresenterBase
import demo.movie.app.util.rx.BaseSchedulerProvider
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class MoviePresenter @Inject constructor(
    private var moviesRepo: BaseMoviesRepo,
    private var schedulerProvider: BaseSchedulerProvider
) :
    PresenterBase<MovieContract.MovieView>(),
    MovieContract.MoviePresenter {

    companion object {
        private const val TAG = "MoviePresenter"
    }

    private var moviesLists : MoviesListsWrapper? = null


    override fun getAllData() {
        val topRatedMoviesObservable = moviesRepo.getTopRated()
        val popularMoviesObservable = moviesRepo.getPopular()
        val trendingMoviesObservable = moviesRepo.getTrendingPerDay()

        Observable.combineLatest(
            topRatedMoviesObservable,
            popularMoviesObservable,
            trendingMoviesObservable,
            { topRated: MoviesResponseResult,
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
                onMoviesListsReceived(it)
            }, {
                view?.showLoadError()
                Log.e(TAG, "getAllData(): ", it)
            })


    }

    private fun onMoviesListsReceived(data: MoviesListsWrapper) {
        moviesLists = data

        setMoviesLists(data)

        view?.showData()
    }

    private fun setMoviesLists(data: MoviesListsWrapper){
        view?.setTopRated(data.topRatedMovies)
        view?.setPopular(data.popularMovies)
        view?.setTrending(data.trendingMovies)
    }

    override fun refreshAllData() {
        TODO("Not yet implemented")
    }


    override fun viewIsReady() {
        if (moviesLists == null)
            getAllData()
        else{
            moviesLists?.let { setMoviesLists(it) }
            view?.showData()
        }
    }

    override fun destroy() {
        TODO("Not yet implemented")
    }

}