package demo.movie.app.ui.detail

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import demo.movie.app.R
import demo.movie.app.model.dto.movie.MovieDetailDto
import javax.inject.Inject

class MovieDetailActivity : DaggerAppCompatActivity(), MovieDetailContract.View {

    @Inject
    lateinit var presenter: MovieDetailContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)

        presenter.attachView(this)
    }

    override fun onDestroy() {
        super.onDestroy()

        presenter.detachView()
    }

    override fun showData(movie: MovieDetailDto) {
        TODO("Not yet implemented")
    }

}