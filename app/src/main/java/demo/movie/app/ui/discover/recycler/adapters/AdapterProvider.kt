package demo.movie.app.ui.discover.recycler.adapters

import demo.movie.app.util.image.BaseImageLoader
import javax.inject.Inject

class AdapterProvider @Inject constructor() : BaseAdapterProvider(){

    private var adapterPopularMovies: MovieAdapter? = null

    private var adapterTrendingMovies: MovieAdapter? = null

    private var adapterTopRatedMovies: MovieAdapter? = null

    @Inject
    lateinit var imageLoader: BaseImageLoader

    override fun getPopularMoviesAdapter(): MovieAdapter {
        return if (adapterPopularMovies == null){
            val adapter = MovieAdapter(onMovieClick, imageLoader)
            adapterPopularMovies = adapter
            adapter
        } else {
            adapterPopularMovies as MovieAdapter
        }
    }

    override fun getTrendingMoviesAdapter(): MovieAdapter {
        return if (adapterTrendingMovies == null){
            val adapter = MovieAdapter(onMovieClick, imageLoader)
            adapterTrendingMovies = adapter
            adapter
        } else {
            adapterTrendingMovies as MovieAdapter
        }
    }

    override fun getTopRatedMoviesAdapter(): MovieAdapter {
        return if (adapterTopRatedMovies == null){
            val adapter = MovieAdapter(onMovieClick, imageLoader)
            adapterTopRatedMovies = adapter
            adapter
        } else {
            adapterTopRatedMovies as MovieAdapter
        }
    }
}