package demo.movie.app.model.services

import demo.movie.app.model.api.MoviesApi
import demo.movie.app.model.api.TvSeriesApi
import demo.movie.app.model.dto.movie.MoviesResponseResult
import demo.movie.app.model.dto.tv.TvResponseResult
import demo.movie.app.util.Constants.API_KEY
import io.reactivex.rxjava3.core.Observable
import retrofit2.Retrofit
import javax.inject.Inject

class NetworkService @Inject constructor() : BaseNetworkService {

    @Inject
    lateinit var retrofit: Retrofit

    @Inject
    lateinit var moviesApi: MoviesApi

    @Inject
    lateinit var tvSeriesApi: TvSeriesApi

    override fun getPopularMovies(): Observable<MoviesResponseResult> =
        moviesApi.getPopular(API_KEY)

    override fun getTrendingPerWeekMovies(): Observable<MoviesResponseResult> =
        moviesApi.getTrendingPerWeek(API_KEY)

    override fun getTrendingPerDayMovies(): Observable<MoviesResponseResult> =
        moviesApi.getTrendingPerDay(API_KEY)

    override fun getTopRatedMovies(): Observable<MoviesResponseResult> =
        moviesApi.getTopRated(API_KEY)

    override fun getPopularTv(): Observable<TvResponseResult> {
        TODO("Not yet implemented")
    }

    override fun getTrendingPerDayTv(): Observable<TvResponseResult> {
        TODO("Not yet implemented")
    }

    override fun getTrendingPerWeekTv(): Observable<TvResponseResult> {
        TODO("Not yet implemented")
    }

    override fun getTopRatedTv(): Observable<TvResponseResult> {
        TODO("Not yet implemented")
    }

}