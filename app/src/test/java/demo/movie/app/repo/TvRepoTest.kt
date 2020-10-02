package demo.movie.app.repo

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
}