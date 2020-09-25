package demo.movie.app.ui.detail

import android.os.Bundle
import android.os.ParcelFormatException
import android.view.View
import dagger.android.support.DaggerAppCompatActivity
import demo.movie.app.R
import demo.movie.app.model.dto.movie.MovieDetailDto
import demo.movie.app.model.dto.movie.MoviePreviewDto
import demo.movie.app.util.image.BaseImageLoader
import demo.movie.app.util.image.ImageSize
import kotlinx.android.synthetic.main.detail_activity.*
import javax.inject.Inject

class MovieDetailActivity : DaggerAppCompatActivity(), MovieDetailContract.View {

    companion object {
        const val MOVIE_PREVIEW_EXTRA_NAME = "movie_id"
    }

    @Inject
    lateinit var presenter: MovieDetailContract.Presenter

    @Inject
    lateinit var imageLoader: BaseImageLoader

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)

        val moviePreview = intent.getParcelableExtra<MoviePreviewDto>(MOVIE_PREVIEW_EXTRA_NAME)
            ?: throw ParcelFormatException()
        presenter.setMoviePreviewAndUpdateDetails(moviePreview)

        presenter.attachView(this)
        presenter.viewIsReady()
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

    }

    override fun showFullData(movieDetail: MovieDetailDto) {

    }

}