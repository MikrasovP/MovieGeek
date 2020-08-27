package demo.movie.app.model.repo

import demo.movie.app.model.dto.movie.MoviesResponseResult
import demo.movie.app.model.services.BaseNetworkService
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class MoviesRepo @Inject constructor() : BaseMoviesRepo {

    @Inject
    lateinit var networkService: BaseNetworkService

    override fun getPopular(): Observable<MoviesResponseResult> =
        networkService.getPopularMovies()

    override fun getTrendingPerWeek(): Observable<MoviesResponseResult> =
        networkService.getTrendingPerWeek()

    override fun getTrendingPerDay(): Observable<MoviesResponseResult> =
        networkService.getTrendingPerDay()

    override fun getTopRated(): Observable<MoviesResponseResult> =
        networkService.getTopRated()

}