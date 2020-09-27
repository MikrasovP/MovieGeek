package demo.movie.app.repo

import demo.movie.app.model.dto.*
import demo.movie.app.model.dto.movie.MovieDetailDto
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
        val PROPER_MOVIE_PREVIEW_RESPONSE =
            MoviesResponseResult(
                immutableListOf(
                    MoviePreviewDto(
                        id = 1,
                        isAdult = false,
                        voteAverage = 1.1,
                        title = "TITLE",
                        originalName = "TITLE_POPULAR",
                        releaseDate = "11-11-2011",
                        posterPath = "/asdfgf.jpg",
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
                revenue = 32231123,
                runtime = 122,
                status = MovieStatus.RELEASED,
                tagline = "slogan",
                title = "Tenet plus batman",
                voteAverage = 2.1,
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
            Observable.just(PROPER_MOVIE_PREVIEW_RESPONSE)
        )

        moviesRepo.getPopular().contains(PROPER_MOVIE_PREVIEW_RESPONSE)
    }

    @Test
    fun testGetTrendingPerDay() {
        Mockito.`when`(networkService.getTrendingPerDayMovies()).thenReturn(
            Observable.just(PROPER_MOVIE_PREVIEW_RESPONSE)
        )

        moviesRepo.getTrendingPerDay().contains(PROPER_MOVIE_PREVIEW_RESPONSE)
    }

    @Test
    fun testGetTrendingPerWeek() {
        Mockito.`when`(networkService.getTrendingPerWeekMovies()).thenReturn(
            Observable.just(PROPER_MOVIE_PREVIEW_RESPONSE)
        )

        moviesRepo.getTrendingPerWeek().contains(PROPER_MOVIE_PREVIEW_RESPONSE)
    }

    @Test
    fun testGetTopRated() {
        Mockito.`when`(networkService.getTopRatedMovies()).thenReturn(
            Observable.just(PROPER_MOVIE_PREVIEW_RESPONSE)
        )

        moviesRepo.getTopRated().contains(PROPER_MOVIE_PREVIEW_RESPONSE)
    }

    @Test
    fun testGetMovieDetails() {
        Mockito.`when`(networkService.getMovieDetails(PROPER_MOVIE_DETAILS_ID)).thenReturn(
            Observable.just(PROPER_MOVIE_DETAILS_RESPONSE)
        )

        moviesRepo.getMovieDetails(PROPER_MOVIE_DETAILS_ID)
            .contains(PROPER_MOVIE_DETAILS_RESPONSE)
    }
}