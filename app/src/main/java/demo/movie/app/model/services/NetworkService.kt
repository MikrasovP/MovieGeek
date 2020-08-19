package demo.movie.app.model.services

import demo.movie.app.model.api.MoviesApi
import demo.movie.app.model.dto.MoviePreviewDto
import demo.movie.app.util.Constants.API_KEY
import io.reactivex.rxjava3.core.Observable
import retrofit2.Retrofit
import javax.inject.Inject

class NetworkService @Inject constructor() : BaseNetworkService {

    @Inject
    lateinit var retrofit: Retrofit

    @Inject
    lateinit var moviesApi: MoviesApi

    override fun getPopularMovies(): Observable<List<MoviePreviewDto>> =
        moviesApi.getPopular(API_KEY)

    override fun getTrendingPerWeek(): Observable<List<MoviePreviewDto>> =
        moviesApi.getTrendingPerWeek(API_KEY)

    override fun getTrendingPerDay(): Observable<List<MoviePreviewDto>> =
        moviesApi.getTrendingPerDay(API_KEY)

    override fun getTopRated(): Observable<List<MoviePreviewDto>> =
        moviesApi.getTopRated(API_KEY)

}