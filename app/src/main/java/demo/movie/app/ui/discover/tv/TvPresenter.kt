package demo.movie.app.ui.discover.tv

import android.util.Log
import demo.movie.app.model.dto.tv.TvListsWrapper
import demo.movie.app.model.dto.tv.TvResponseResult
import demo.movie.app.model.repo.tv.BaseTvRepo
import demo.movie.app.ui.mvp.PresenterBase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.functions.Function3
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class TvPresenter @Inject constructor(): PresenterBase<TvContract.TvView>(), TvContract.TvPresenter {

    companion object {
        private const val TAG = "TvPresenter"
    }

    @Inject
    lateinit var tvRepo: BaseTvRepo

    private var isDataLoaded = false


    override fun getAllData() {
        val topRatedMoviesObservable = tvRepo.getTopRated()
        val popularMoviesObservable = tvRepo.getPopular()
        val trendingMoviesObservable = tvRepo.getTrendingPerDay()

        Observable.combineLatest(
            topRatedMoviesObservable,
            popularMoviesObservable,
            trendingMoviesObservable,
            Function3 { topRated: TvResponseResult,
                             popular: TvResponseResult,
                             trending: TvResponseResult ->
                TvListsWrapper(
                    topRated = topRated.results,
                    popular = popular.results,
                    trending = trending.results
                )
            })
            .subscribeOn(Schedulers.io())
            .doOnSubscribe {
                view?.showLoadingProgressBar()
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view?.setTopRated(it.topRated)
                view?.setPopular(it.popular)
                view?.setTrending(it.trending)

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
        if(!isDataLoaded)
            getAllData()
        else
            view?.showData()
    }

    override fun destroy() {
        TODO("Not yet implemented")
    }
}