package demo.movie.app.ui.discover.movie

import android.util.Log
import demo.movie.app.model.dto.movie.MoviesListsWrapper
import demo.movie.app.model.dto.movie.MoviesResponseResult
import demo.movie.app.model.repo.movies.BaseMoviesRepo
import demo.movie.app.ui.mvp.PresenterBase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.functions.Function3
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class MoviePresenter @Inject constructor() : PresenterBase<MovieContract.MovieView>(),
    MovieContract.MoviePresenter {

    companion object {
        private const val TAG = "MoviePresenter"
    }

    @Inject
    lateinit var moviesRepo: BaseMoviesRepo

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
            .subscribeOn(Schedulers.io())
            .doOnSubscribe {
                view?.showLoadingProgressBar()
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view?.setTopRated(it.topRatedMovies)
                view?.setPopular(it.popularMovies)
                view?.setTrending(it.trendingMovies)

                view?.showData()
                isDataLoaded = true
            }, {
                view?.showLoadError()
                Log.e(TAG, "getAllData(): ", it)
            })


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