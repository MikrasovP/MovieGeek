package demo.movie.app.presenter

import demo.movie.app.model.dto.movie.MoviePreviewDto
import demo.movie.app.model.dto.movie.MoviesResponseResult
import demo.movie.app.model.repo.movies.MoviesRepo
import demo.movie.app.ui.discover.movie.MovieContract
import demo.movie.app.ui.discover.movie.MoviePresenter
import demo.movie.app.util.rx.TrampolineSchedulerProvider
import io.reactivex.rxjava3.core.Observable
import okhttp3.internal.immutableListOf
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MoviePresenterTest {

    private companion object {
        val FAKE_POPULAR_MOVIES_RESPONSE_RESULT =
            MoviesResponseResult(
                immutableListOf(
                    MoviePreviewDto(
                        1, false,
                        1.1, "TITLE",
                        "TITLE_POPULAR", "11-11-2011",
                        "/asdfgf.jpg"
                    )
                )
            )
        val FAKE_TRENDING_MOVIES_RESPONSE_RESULT =
            MoviesResponseResult(
                immutableListOf(
                    MoviePreviewDto(
                        2, false,
                        1.1, "TITLE",
                        "TITLE_TRENDING", "11-11-2011",
                        "/asdfgf.jpg"
                    )
                )
            )
        val FAKE_TOP_RATED_MOVIES_RESPONSE_RESULT =
            MoviesResponseResult(
                immutableListOf(
                    MoviePreviewDto(
                        3, false,
                        1.1, "TITLE",
                        "TITLE_TOP", "11-11-2011",
                        "/asdfgf.jpg"
                    )
                )
            )
    }

    private lateinit var moviePresenter: MoviePresenter

    @Mock
    private lateinit var moviesRepo: MoviesRepo

    @Mock
    private lateinit var view: MovieContract.MovieView

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        moviePresenter = MoviePresenter(moviesRepo, TrampolineSchedulerProvider())
        moviePresenter.attachView(view)
    }

    @Test
    fun testLoadAllData() {
        Mockito.`when`(moviesRepo.getPopular()).thenReturn(
            Observable.just(
                FAKE_POPULAR_MOVIES_RESPONSE_RESULT
            )
        )
        Mockito.`when`(moviesRepo.getTrendingPerDay()).thenReturn(
            Observable.just(
                FAKE_TRENDING_MOVIES_RESPONSE_RESULT
            )
        )
        Mockito.`when`(moviesRepo.getTopRated()).thenReturn(
            Observable.just(
                FAKE_TOP_RATED_MOVIES_RESPONSE_RESULT
            )
        )

        moviePresenter.getAllData()
        Mockito.verify(moviesRepo).getPopular()
        Mockito.verify(moviesRepo).getTrendingPerDay()
        Mockito.verify(moviesRepo).getTopRated()

        Mockito.verify(view).setPopular(FAKE_POPULAR_MOVIES_RESPONSE_RESULT.results)
        Mockito.verify(view).setTrending(FAKE_TRENDING_MOVIES_RESPONSE_RESULT.results)
        Mockito.verify(view).setTopRated(FAKE_TOP_RATED_MOVIES_RESPONSE_RESULT.results)

        Mockito.verify(view).showData()
    }
}