package demo.movie.app.repo

import demo.movie.app.model.dto.movie.MoviePreviewDto
import demo.movie.app.model.dto.movie.MoviesResponseResult
import demo.movie.app.model.repo.movies.MoviesRepo
import demo.movie.app.model.services.BaseNetworkService
import io.reactivex.rxjava3.core.Observable
import okhttp3.internal.immutableListOf
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MoviesRepoTest {

    private companion object {
        val PROPER_RESPONSE =
            MoviesResponseResult(
                immutableListOf(
                    MoviePreviewDto(
                        id = 1,
                        isAdult = false,
                        voteAverage = 1.1,
                        title = "TITLE",
                        originalName = "TITLE_POPULAR",
                        releaseDate = "11-11-2011",
                        posterPath = "/asdfgf.jpg"
                    )
                )
            )
    }

    @Mock
    private lateinit var networkService: BaseNetworkService

    private lateinit var moviesRepo: MoviesRepo

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        moviesRepo = MoviesRepo(networkService)
    }

    @Test
    fun testGetPopular() {
        Mockito.`when`(networkService.getPopularMovies()).thenReturn(
            Observable.just(PROPER_RESPONSE)
        )

        moviesRepo.getPopular().contains(PROPER_RESPONSE)
    }

    @Test
    fun testGetTrendingPerDay() {
        Mockito.`when`(networkService.getTrendingPerDayMovies()).thenReturn(
            Observable.just(PROPER_RESPONSE)
        )

        moviesRepo.getTrendingPerDay().contains(PROPER_RESPONSE)
    }

    @Test
    fun testGetTrendingPerWeek() {
        Mockito.`when`(networkService.getTrendingPerWeekMovies()).thenReturn(
            Observable.just(PROPER_RESPONSE)
        )

        moviesRepo.getTrendingPerWeek().contains(PROPER_RESPONSE)
    }

    @Test
    fun testGetTopRated() {
        Mockito.`when`(networkService.getTopRatedMovies()).thenReturn(
            Observable.just(PROPER_RESPONSE)
        )

        moviesRepo.getTopRated().contains(PROPER_RESPONSE)
    }
}