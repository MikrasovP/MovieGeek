package demo.movie.app.repo

import demo.movie.app.model.dto.CastMemberDto
import demo.movie.app.model.dto.Credits
import demo.movie.app.model.dto.CrewMemberDto
import demo.movie.app.model.dto.Genre
import demo.movie.app.model.dto.tv.TvDetailDto
import demo.movie.app.model.dto.tv.TvPreviewDto
import demo.movie.app.model.dto.tv.TvResponseResult
import demo.movie.app.model.repo.tv.TvSeriesRepo
import demo.movie.app.model.services.BaseNetworkService
import io.reactivex.rxjava3.core.Observable
import okhttp3.internal.immutableListOf
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class TvRepoTest {

    private companion object {
        val PROPER_RESPONSE_TV =
            TvResponseResult(
                immutableListOf(
                    TvPreviewDto(
                        id = 2,
                        voteAverage = 1.1,
                        title = "TITLE",
                        originalName = "TITLE_ORIGINAL",
                        releaseDate = "11-11-1111",
                        posterPath = "/asdibasduvbasduv.jpg"
                    )
                )
            )
        const val PROPER_TV_DETAILS_ID = 2
        val PROPER_TV_DETAILS_RESPONSE =
            TvDetailDto(
                id = 2,
                credits = Credits(
                    id = 1,
                    cast = immutableListOf(
                        CastMemberDto(
                            id = 10000,
                            character = "Batman",
                            profile_path = "path",
                            name = "Donald Duck",
                            order = 1,
                        ),
                        CastMemberDto(
                            id = 12000,
                            character = "Joker",
                            profile_path = "path",
                            name = "Mickey Mouse",
                            order = 1,
                        )
                    ),
                    crew = immutableListOf(
                        CrewMemberDto(
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
                posterPath = "/1idsuvmd",
                recommendations = PROPER_RESPONSE_TV,
                firstAirDate = "2019-09-12",
                status = "Returning Series",
                title = "Tenet plus batman",
                voteAverage = 2.1,
                episodeRuntime = listOf(50, 40),
                lastAirDate = "2020-11-01",
            )
    }

    @Mock
    private lateinit var networkService: BaseNetworkService

    private lateinit var tvSeriesRepo: TvSeriesRepo

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        tvSeriesRepo = TvSeriesRepo(networkService)
    }

    @Test
    fun testGetPopular() {
        Mockito.`when`(networkService.getPopularTv()).thenReturn(
            Observable.just(PROPER_RESPONSE_TV)
        )

        tvSeriesRepo.getPopular().contains(PROPER_RESPONSE_TV)
    }

    @Test
    fun testGetTrendingPerDay() {
        Mockito.`when`(networkService.getTrendingPerDayTv()).thenReturn(
            Observable.just(PROPER_RESPONSE_TV)
        )

        tvSeriesRepo.getTrendingPerDay().contains(PROPER_RESPONSE_TV)
    }

    @Test
    fun testGetTrendingPerWeek() {
        Mockito.`when`(networkService.getTrendingPerWeekTv()).thenReturn(
            Observable.just(PROPER_RESPONSE_TV)
        )

        tvSeriesRepo.getTrendingPerWeek().contains(PROPER_RESPONSE_TV)
    }

    @Test
    fun testGetTopRated() {
        Mockito.`when`(networkService.getTopRatedTv()).thenReturn(
            Observable.just(PROPER_RESPONSE_TV)
        )

        tvSeriesRepo.getTopRated().contains(PROPER_RESPONSE_TV)
    }

    @Test
    fun testGetTvDetails() {
        Mockito.`when`(networkService.getTvDetails(Mockito.anyInt())).thenReturn(
            Observable.just(PROPER_TV_DETAILS_RESPONSE)
        )
        tvSeriesRepo.getTvDetails(PROPER_TV_DETAILS_ID).contains(PROPER_TV_DETAILS_RESPONSE)
    }
}