package demo.movie.app.model.repo

import demo.movie.app.model.dto.MoviePreviewDto
import demo.movie.app.model.services.BaseNetworkService
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class MoviesRepo @Inject constructor() : BaseMoviesRepo {

    @Inject
    lateinit var networkService: BaseNetworkService

    override fun getPopularMovies(): Observable<List<MoviePreviewDto>> =
        networkService.getPopularMovies()

    override fun getTrendingPerWeek(): Observable<List<MoviePreviewDto>> =
        networkService.getTrendingPerWeek()

    override fun getTrendingPerDay(): Observable<List<MoviePreviewDto>> =
        networkService.getTrendingPerDay()

    override fun getTopRated(): Observable<List<MoviePreviewDto>> =
        networkService.getTopRated()

}