package demo.movie.app.ui.detail

import android.os.Bundle
import android.os.ParcelFormatException
import dagger.android.support.DaggerAppCompatActivity
import demo.movie.app.R
import demo.movie.app.model.dto.movie.MovieDetailDto
import demo.movie.app.model.dto.movie.MoviePreviewDto
import demo.movie.app.ui.recycler.adapters.BaseAdapterProvider
import demo.movie.app.util.DateConverter
import demo.movie.app.util.image.BaseImageLoader
import demo.movie.app.util.image.ImageSize
import kotlinx.android.synthetic.main.detail_activity.*
import java.util.*
import javax.inject.Inject

class MovieDetailActivity : DaggerAppCompatActivity(), MovieDetailContract.View {

    companion object {
        const val MOVIE_PREVIEW_EXTRA_NAME = "movie_id"
    }

    @Inject
    lateinit var presenter: MovieDetailContract.Presenter

    @Inject
    lateinit var imageLoader: BaseImageLoader

    @Inject
    lateinit var adapterProvider: BaseAdapterProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)

        val moviePreview = intent.getParcelableExtra<MoviePreviewDto>(MOVIE_PREVIEW_EXTRA_NAME)
            ?: throw ParcelFormatException()

        presenter.attachView(this)
        initRecyclers()
        presenter.viewIsReady()
        presenter.setMoviePreviewAndUpdateDetails(moviePreview)
    }

    override fun onDestroy() {
        super.onDestroy()

        presenter.detachView()
    }

    override fun showPreviewData(moviePreview: MoviePreviewDto) {
        detail_title_tv.text = moviePreview.title
        imageLoader.loadImagePoster(
            detail_poster_iv,
            moviePreview.posterPath,
            detail_poster_iv,
            ImageSize.W500
        )

        val year =
            DateConverter
                .convertServerDateToCalendar(moviePreview.releaseDate)
                .get(Calendar.YEAR)

        detail_year_tv.text = year.toString()
    }

    override fun showFullData(movieDetail: MovieDetailDto) {
        detail_title_tv.text = movieDetail.title
        imageLoader.loadImagePoster(
            detail_poster_iv,
            movieDetail.posterPath,
            detail_poster_iv,
            ImageSize.W500
        )

        val year =
            DateConverter
                .convertServerDateToCalendar(movieDetail.releaseDate)
                .get(Calendar.YEAR)

        detail_year_tv.text = year.toString()

        detail_genre_tv.text = movieDetail.genres
            .joinToString(separator = ", ") { it.name }

        detail_runtime_tv.text = resources.getText(R.string.detail_runtime_pattern)

        detail_overview_tv.text = movieDetail.overview


    }

    private fun initRecyclers() {
        detail_recommendations_rv.adapter = adapterProvider.getRecommendedMoviesAdapter()
    }

}