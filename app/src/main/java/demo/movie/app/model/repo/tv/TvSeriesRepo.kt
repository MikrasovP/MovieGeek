package demo.movie.app.model.repo.tv

import demo.movie.app.model.dto.tv.TvResponseResult
import demo.movie.app.model.services.BaseNetworkService
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class TvSeriesRepo @Inject constructor(
    var networkService: BaseNetworkService
) : BaseTvRepo {

    override fun getPopular(): Observable<TvResponseResult> =
        networkService.getPopularTv()

    override fun getTrendingPerWeek(): Observable<TvResponseResult> =
        networkService.getTrendingPerWeekTv()

    override fun getTrendingPerDay(): Observable<TvResponseResult> =
        networkService.getTrendingPerDayTv()

    override fun getTopRated(): Observable<TvResponseResult> =
        networkService.getTopRatedTv()
}