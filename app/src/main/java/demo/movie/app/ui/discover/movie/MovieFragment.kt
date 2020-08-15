package demo.movie.app.ui.discover.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import demo.movie.app.R
import demo.movie.app.model.dto.MoviePreviewDto
import demo.movie.app.ui.discover.recycler.adapters.MovieAdapter
import kotlinx.android.synthetic.main.discover_movies_fragment.*

class MovieFragment : Fragment(), MovieContract.MovieView {

    private val adapterPopularMovies = MovieAdapter {
        showMovieDetail(it)
    }

    private val adapterTrendingMovies = MovieAdapter {
        showMovieDetail(it)
    }

    private val adapterTopRatedMovies = MovieAdapter {
        showMovieDetail(it)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.discover_movies_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        retainInstance = true
        initRecyclers()
        testRecyclers()
    }

    private fun initRecyclers() {

        popular_movies_rv.apply {
            adapter = this@MovieFragment.adapterPopularMovies
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        }
        trending_movies_rv.apply {
            adapter = this@MovieFragment.adapterTrendingMovies
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        }
        top_movies_rv.apply {
            adapter = this@MovieFragment.adapterTopRatedMovies
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        }
    }

    /**
     * TODO - move this function to Presenter
     *
     */
    private fun testRecyclers(){
        val data: List<MoviePreviewDto> = listOf(
            MoviePreviewDto(1, true, 4.5, "Довод", "Tenet", "20 августа 2020", "https://upload.wikimedia.org/wikipedia/ru/5/56/Tenet_%28poster%29.jpg"),
            MoviePreviewDto(2, false, 4.5, "Начало", "Inception", "20 августа 2020", "https://upload.wikimedia.org/wikipedia/ru/b/bc/Poster_Inception_film_2010.jpg"),
            MoviePreviewDto(3, true, 4.5, "Однажды в... Голливуде", "Once upon a time in... Hollywood", "20 августа 2020", "https://kinohod.ru/o/72/ba/72ba9feb-2029-45e5-8e42-9d101df11160.jpg"),
            MoviePreviewDto(4, false, 4.5, "Криминальное чтиво", "Pulp fiction", "20 августа 2020", ""),
            MoviePreviewDto(5, true, 4.5, "Титаник", "Titanic", "20 августа 2020", "https://sun1-14.userapi.com/impf/c824201/v824201969/173424/ayWCFmi538s.jpg?size=200x0&quality=90&sign=b461a01af900c4374512c2b13455c25d&ava=1")
        )

        showPopular(data)
        showTrending(data)
        showTopRated(data)
    }

    override fun showPopular(popularMovieList: List<MoviePreviewDto>) {
        adapterPopularMovies.updateData(popularMovieList)
    }

    override fun showTrending(trendingMovieList: List<MoviePreviewDto>) {
        adapterTrendingMovies.updateData(trendingMovieList)
    }

    override fun showTopRated(topRatedMovieList: List<MoviePreviewDto>) {
        adapterTopRatedMovies.updateData(topRatedMovieList)
    }

    override fun showLoadError() {
        TODO("Not yet implemented")
    }

    override fun showLoadingProgressBar() {
        TODO("Not yet implemented")
    }

    override fun showReloadError() {
        TODO("Not yet implemented")
    }

    override fun showMovieDetail(movie: MoviePreviewDto) {
        TODO("Navigate to movie info fragment")
    }

}