package demo.movie.app.model.repo.movies

import demo.movie.app.model.dto.movie.MovieDetailDto
import demo.movie.app.model.dto.movie.MoviesResponseResult
import demo.movie.app.model.services.BaseNetworkService
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class MoviesRepo @Inject constructor(
    var networkService: BaseNetworkService
) : BaseMoviesRepo {

    override fun getPopular(): Observable<MoviesResponseResult> =
        networkService.getPopularMovies()

    override fun getTrendingPerWeek(): Observable<MoviesResponseResult> =
        networkService.getTrendingPerWeekMovies()

    override fun getTrendingPerDay(): Observable<MoviesResponseResult> =
        networkService.getTrendingPerDayMovies()

    override fun getTopRated(): Observable<MoviesResponseResult> =
        networkService.getTopRatedMovies()

    override fun getMovieDetails(id: Int): Observable<MovieDetailDto> =
        networkService.getMovieDetails(id)
}