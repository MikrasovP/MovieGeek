package demo.movie.app.model.services

import demo.movie.app.model.api.MoviesApi
import demo.movie.app.model.api.TvSeriesApi
import demo.movie.app.model.dto.movie.MovieDetailDto
import demo.movie.app.model.dto.movie.MoviesResponseResult
import demo.movie.app.model.dto.tv.TvResponseResult
import demo.movie.app.util.Constants.API_KEY
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class NetworkService @Inject constructor(
    var moviesApi: MoviesApi,
    var tvSeriesApi: TvSeriesApi
) : BaseNetworkService {

    override fun getPopularMovies(): Observable<MoviesResponseResult> =
        moviesApi.getPopular(API_KEY)

    override fun getTrendingPerWeekMovies(): Observable<MoviesResponseResult> =
        moviesApi.getTrendingPerWeek(API_KEY)

    override fun getTrendingPerDayMovies(): Observable<MoviesResponseResult> =
        moviesApi.getTrendingPerDay(API_KEY)

    override fun getTopRatedMovies(): Observable<MoviesResponseResult> =
        moviesApi.getTopRated(API_KEY)

    override fun getMovieDetails(id: Int): Observable<MovieDetailDto> =
        moviesApi.getMovie(id)

    override fun getPopularTv(): Observable<TvResponseResult> =
        tvSeriesApi.getPopular(API_KEY)

    override fun getTrendingPerDayTv(): Observable<TvResponseResult> =
        tvSeriesApi.getTrendingPerDay(API_KEY)

    override fun getTrendingPerWeekTv(): Observable<TvResponseResult> =
        tvSeriesApi.getTrendingPerWeek(API_KEY)

    override fun getTopRatedTv(): Observable<TvResponseResult> =
        tvSeriesApi.getTopRated(API_KEY)

}