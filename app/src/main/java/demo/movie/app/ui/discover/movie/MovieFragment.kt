package demo.movie.app.ui.discover.movie

import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import demo.movie.app.R
import demo.movie.app.model.dto.MoviePreviewDto
import demo.movie.app.ui.discover.adapters.MovieAdapter
import kotlinx.android.synthetic.main.discover_movies_fragment.*

class MovieFragment : Fragment(), MovieContract.MovieView {

    private val adapterPopular = MovieAdapter {
        showMovieDetail(it)
    }

    private val adapterTrending = MovieAdapter {
        showMovieDetail(it)
    }

    private val adapterTop = MovieAdapter {
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
    }

    private fun initRecyclers() {
        val decorator = object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                val space = resources.getDimension(R.dimen.spacing_small_8).toInt()
                println(space)
                with(outRect) {
                    top = space
                    left =  space
                    right = space
                    bottom = space
                }
            }
        }
        val linearLayoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.HORIZONTAL,
            false
        )

        popular_movies_rv.apply {
            adapter = this@MovieFragment.adapterPopular
            layoutManager = linearLayoutManager
            addItemDecoration(decorator)
        }
        trending_movies_rv.apply {
            adapter = this@MovieFragment.adapterTrending
            layoutManager = linearLayoutManager
            addItemDecoration(decorator)
        }
        top_movies_rv.apply {
            adapter = this@MovieFragment.adapterTop
            layoutManager = linearLayoutManager
            addItemDecoration(decorator)
        }
    }

    override fun showPopular(popularMovieList: List<MoviePreviewDto>) {
        TODO("Not yet implemented")
    }

    override fun showTrending(trendingMovieList: List<MoviePreviewDto>) {
        TODO("Not yet implemented")
    }

    override fun showTopRated(topRatedMovieList: List<MoviePreviewDto>) {
        TODO("Not yet implemented")
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

    private fun showMovieDetail(movie: MoviePreviewDto) {
        TODO("Navigate to movie info fragment")
    }

}