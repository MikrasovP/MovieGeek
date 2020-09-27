package demo.movie.app

import demo.movie.app.model.api.MoviesApi
import demo.movie.app.model.api.TvSeriesApi
import demo.movie.app.model.dto.*
import demo.movie.app.model.dto.movie.MovieDetailDto
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
        val PROPER_MOVIE_PREVIEW_RESPONSE =
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

        const val PROPER_MOVIE_DETAILS_ID = 1
        val PROPER_MOVIE_DETAILS_RESPONSE =
            MovieDetailDto(
                id = 1,
                isAdult = false,
                budget = 1000,
                credits = Credits(
                    id = 1,
                    cast = immutableListOf(
                        CastMember(
                            id = 10000,
                            character = "Batman",
                            profile_path = "path",
                            name = "Donald Duck",
                            order = 1,
                        ),
                        CastMember(
                            id = 12000,
                            character = "Joker",
                            profile_path = "path",
                            name = "Mickey Mouse",
                            order = 1,
                        )
                    ),
                    crew = immutableListOf(
                        CrewMember(
                            id = 2341,
                            job = "director",
                            name = "Christopher Nolan",
                            profilePath = "/hguavhbnasdv",
                        )
                    )
                ),
                genres = immutableListOf(
                    Genre(1, "thriller"),
                    Genre(2, "action")
                ),
                originalLanguage = "en",
                overview = "hehehe, description",
                posterPath = "/1idsuv,md",
                recommendations = PROPER_MOVIE_PREVIEW_RESPONSE,
                releaseDate = "2019-09-12",
                revenue = 32231123,
                runtime = 122,
                status = MovieStatus.RELEASED,
                tagline = "slogan",
                title = "Tenet plus batman",
                voteAverage = 2.1,
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
                PROPER_MOVIE_PREVIEW_RESPONSE
            )
        )

        networkService.getPopularMovies().contains(PROPER_MOVIE_PREVIEW_RESPONSE)
    }

    @Test
    fun testGetTopRatedMovies() {
        Mockito.`when`(moviesApi.getTopRated(Mockito.anyString())).thenReturn(
            Observable.just(
                PROPER_MOVIE_PREVIEW_RESPONSE
            )
        )

        networkService.getTopRatedMovies().contains(PROPER_MOVIE_PREVIEW_RESPONSE)
    }

    @Test
    fun testGetTrendingPerDayMovies() {
        Mockito.`when`(moviesApi.getTrendingPerDay(Mockito.anyString())).thenReturn(
            Observable.just(
                PROPER_MOVIE_PREVIEW_RESPONSE
            )
        )

        networkService.getTrendingPerDayMovies().contains(PROPER_MOVIE_PREVIEW_RESPONSE)
    }

    @Test
    fun testGetTrendingPerWeekMovies() {
        Mockito.`when`(moviesApi.getTrendingPerWeek(Mockito.anyString())).thenReturn(
            Observable.just(
                PROPER_MOVIE_PREVIEW_RESPONSE
            )
        )

        networkService.getTrendingPerWeekMovies().contains(PROPER_MOVIE_PREVIEW_RESPONSE)
    }

    @Test
    fun testGetMovieDetails() {
        Mockito.`when`(
            moviesApi.getMovie(
                Mockito.eq(PROPER_MOVIE_DETAILS_ID),
                Mockito.anyString()
            )
        ).thenReturn(
            Observable.just(
                PROPER_MOVIE_DETAILS_RESPONSE
            )
        )

        networkService.getMovieDetails(PROPER_MOVIE_DETAILS_ID)
            .contains(PROPER_MOVIE_DETAILS_RESPONSE)
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