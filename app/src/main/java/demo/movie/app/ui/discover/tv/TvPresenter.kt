package demo.movie.app.ui.discover.tv

import android.util.Log
import demo.movie.app.model.dto.tv.TvListsWrapper
import demo.movie.app.model.dto.tv.TvResponseResult
import demo.movie.app.model.repo.tv.BaseTvRepo
import demo.movie.app.ui.mvp.PresenterBase
import demo.movie.app.util.rx.BaseSchedulerProvider
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class TvPresenter @Inject constructor(
    var tvRepo: BaseTvRepo,
    var schedulerProvider: BaseSchedulerProvider
) : PresenterBase<TvContract.TvView>(),
    TvContract.TvPresenter {

    companion object {
        private const val TAG = "TvPresenter"
    }

    private var tvLists: TvListsWrapper? = null

    override fun getAllData() {
        val topRatedMoviesObservable = tvRepo.getTopRated()
        val popularMoviesObservable = tvRepo.getPopular()
        val trendingMoviesObservable = tvRepo.getTrendingPerDay()

        Observable.combineLatest(
            topRatedMoviesObservable,
            popularMoviesObservable,
            trendingMoviesObservable,
            { topRated: TvResponseResult,
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
                onTvListsReceived(it)
            }, {
                view?.showLoadError()
                Log.e(TAG, "getAllData(): ", it)
            })


    }

    private fun onTvListsReceived(data: TvListsWrapper) {
        tvLists = data

        setTvLists(data)

        view?.showData()
    }

    private fun setTvLists(data: TvListsWrapper){
        view?.setTopRated(data.topRated)
        view?.setPopular(data.popular)
        view?.setTrending(data.trending)
    }

    override fun refreshAllData() {
        TODO("Not yet implemented")
    }


    override fun viewIsReady() {
        if (tvLists == null)
            getAllData()
        else{
            tvLists?.let { setTvLists(it) }
            view?.showData()
        }

    }

    override fun destroy() {
        TODO("Not yet implemented")
    }
}