package demo.movie.app.ui.detail

import dagger.android.support.DaggerAppCompatActivity
import demo.movie.app.model.dto.movie.MovieDetailDto
import javax.inject.Inject

class MovieDetailActivity : DaggerAppCompatActivity(), MovieDetailContract.View {

    @Inject
    lateinit var presenter: MovieDetailContract.Presenter

    override fun showData(movie: MovieDetailDto) {
        TODO("Not yet implemented")
    }

}