package demo.movie.app

import demo.movie.app.model.api.MoviesApi
import demo.movie.app.model.api.TvSeriesApi
import demo.movie.app.model.dto.movie.MoviePreviewDto
import demo.movie.app.model.dto.movie.MoviesResponseResult
import demo.movie.app.model.dto.tv.TvPreviewDto
import demo.movie.app.model.dto.tv.TvResponseResult
import demo.movie.app.model.services.NetworkService
import io.reactivex.rxjava3.core.Observable
import okhttp3.internal.immutableListOf
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class NetworkServiceTest {

    private companion object {
        val PROPER_RESPONSE_MOVIE =
            MoviesResponseResult(
                immutableListOf(
                    MoviePreviewDto(
                        id = 1,
                        isAdult = false,
                        voteAverage = 1.1,
                        title = "TITLE",
                        originalName = "TITLE_ORIGINAL",
                        releaseDate = "11-11-2011",
                        posterPath = "/asdfgf.jpg"
                    )
                )
            )

        val PROPER_RESPONSE_TV =
            TvResponseResult(
                immutableListOf(
                    TvPreviewDto(
                        id = 2,
                        voteAverage = 1.1,
                        title = "TITLE",
                        original_name = "TITLE_ORIGINAL",
                        release_date = "11-11-1111",
                        poster_path = "/asdibasduvbasduv.jpg"
                    )
                )
            )
    }

    private lateinit var networkService: NetworkService

    @Mock
    private lateinit var moviesApi: MoviesApi

    @Mock
    private lateinit var tvSeriesApi: TvSeriesApi

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        networkService = NetworkService(moviesApi, tvSeriesApi)
    }

    @Test
    fun testGetPopularMovies() {
        Mockito.`when`(moviesApi.getPopular(Mockito.anyString())).thenReturn(
            Observable.just(
                PROPER_RESPONSE_MOVIE
            )
        )

        networkService.getPopularMovies().contains(PROPER_RESPONSE_MOVIE)
    }

    @Test
    fun testGetTopRatedMovies() {
        Mockito.`when`(moviesApi.getTopRated(Mockito.anyString())).thenReturn(
            Observable.just(
                PROPER_RESPONSE_MOVIE
            )
        )

        networkService.getTopRatedMovies().contains(PROPER_RESPONSE_MOVIE)
    }

    @Test
    fun testGetTrendingPerDayMovies() {
        Mockito.`when`(moviesApi.getTrendingPerDay(Mockito.anyString())).thenReturn(
            Observable.just(
                PROPER_RESPONSE_MOVIE
            )
        )

        networkService.getTrendingPerDayMovies().contains(PROPER_RESPONSE_MOVIE)
    }

    @Test
    fun testGetTrendingPerWeekMovies() {
        Mockito.`when`(moviesApi.getTrendingPerWeek(Mockito.anyString())).thenReturn(
            Observable.just(
                PROPER_RESPONSE_MOVIE
            )
        )

        networkService.getTrendingPerWeekMovies().contains(PROPER_RESPONSE_MOVIE)
    }

    @Test
    fun testGetPopularTv() {
        Mockito.`when`(tvSeriesApi.getPopular(Mockito.anyString())).thenReturn(
            Observable.just(
                PROPER_RESPONSE_TV
            )
        )

        networkService.getPopularTv().contains(PROPER_RESPONSE_TV)
    }

    @Test
    fun testGetTrendingPerDayTv() {
        Mockito.`when`(tvSeriesApi.getTrendingPerDay(Mockito.anyString())).thenReturn(
            Observable.just(
                PROPER_RESPONSE_TV
            )
        )

        networkService.getTrendingPerDayTv().contains(PROPER_RESPONSE_TV)
    }

    @Test
    fun testGetTrendingPerWeekTv() {
        Mockito.`when`(tvSeriesApi.getTrendingPerWeek(Mockito.anyString())).thenReturn(
            Observable.just(
                PROPER_RESPONSE_TV
            )
        )

        networkService.getTrendingPerWeekTv().contains(PROPER_RESPONSE_TV)
    }

    @Test
    fun testGetTopRatedTv() {
        Mockito.`when`(tvSeriesApi.getTopRated(Mockito.anyString())).thenReturn(
            Observable.just(
                PROPER_RESPONSE_TV
            )
        )

        networkService.getTopRatedTv().contains(PROPER_RESPONSE_TV)
    }
}