package demo.movie.app.ui.discover.tv

import android.util.Log
import demo.movie.app.model.dto.tv.TvListsWrapper
import demo.movie.app.model.dto.tv.TvResponseResult
import demo.movie.app.model.repo.tv.BaseTvRepo
import demo.movie.app.ui.mvp.PresenterBase
import demo.movie.app.util.rx.BaseSchedulerProvider
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.functions.Function3
import javax.inject.Inject

class TvPresenter @Inject constructor(
    var tvRepo: BaseTvRepo,
    var schedulerProvider: BaseSchedulerProvider
) : PresenterBase<TvContract.TvView>(),
    TvContract.TvPresenter {

    companion object {
        private const val TAG = "TvPresenter"
    }

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

    private fun onDataReceived(data: TvListsWrapper) {
        view?.setTopRated(data.topRated)
        view?.setPopular(data.popular)
        view?.setTrending(data.trending)

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