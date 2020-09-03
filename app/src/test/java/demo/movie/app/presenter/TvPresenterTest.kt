package demo.movie.app.presenter

import demo.movie.app.model.dto.tv.TvPreviewDto
import demo.movie.app.model.dto.tv.TvResponseResult
import demo.movie.app.model.repo.tv.TvSeriesRepo
import demo.movie.app.ui.discover.tv.TvContract
import demo.movie.app.ui.discover.tv.TvPresenter
import demo.movie.app.util.rx.TrampolineSchedulerProvider
import io.reactivex.rxjava3.core.Observable
import okhttp3.internal.immutableListOf
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class TvPresenterTest {
    private companion object {
        val FAKE_POPULAR_TV_RESPONSE_RESULT =
            TvResponseResult(
                immutableListOf(
                    TvPreviewDto(
                        1, 1.1, "TITLE",
                        "TITLE_POPULAR", "11-11-2011",
                        "/asdfgf.jpg"
                    )
                )
            )
        val FAKE_TRENDING_TV_RESPONSE_RESULT =
            TvResponseResult(
                immutableListOf(
                    TvPreviewDto(
                        2, 1.1, "TITLE",
                        "TITLE_POPULAR", "11-11-2011",
                        "/asdfgf.jpg"
                    )
                )
            )
        val FAKE_TOP_RATED_TV_RESPONSE_RESULT =
            TvResponseResult(
                immutableListOf(
                    TvPreviewDto(
                        3, 1.1, "TITLE",
                        "TITLE_POPULAR", "11-11-2011",
                        "/asdfgf.jpg"
                    )
                )
            )
    }

    private lateinit var tvPresenter: TvPresenter

    @Mock
    private lateinit var tvRepo: TvSeriesRepo

    @Mock
    private lateinit var view: TvContract.TvView

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        tvPresenter = TvPresenter(tvRepo, TrampolineSchedulerProvider())
        tvPresenter.attachView(view)
    }

    @Test
    fun testLoadAllData() {
        Mockito.`when`(tvRepo.getPopular()).thenReturn(
            Observable.just(
                FAKE_POPULAR_TV_RESPONSE_RESULT
            )
        )
        Mockito.`when`(tvRepo.getTrendingPerDay()).thenReturn(
            Observable.just(
                FAKE_TRENDING_TV_RESPONSE_RESULT
            )
        )
        Mockito.`when`(tvRepo.getTopRated()).thenReturn(
            Observable.just(
                FAKE_TOP_RATED_TV_RESPONSE_RESULT
            )
        )

        tvPresenter.getAllData()
        Mockito.verify(tvRepo).getPopular()
        Mockito.verify(tvRepo).getTrendingPerDay()
        Mockito.verify(tvRepo).getTopRated()

        Mockito.verify(view).setPopular(FAKE_POPULAR_TV_RESPONSE_RESULT.results)
        Mockito.verify(view).setTrending(FAKE_TRENDING_TV_RESPONSE_RESULT.results)
        Mockito.verify(view).setTopRated(FAKE_TOP_RATED_TV_RESPONSE_RESULT.results)

        Mockito.verify(view).showData()
    }
}