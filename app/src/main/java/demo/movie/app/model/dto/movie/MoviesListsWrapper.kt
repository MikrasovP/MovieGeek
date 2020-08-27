package demo.movie.app.model.dto.movie

data class MoviesListsWrapper(
    val topRatedMovies: List<MoviePreviewDto>,
    val popularMovies: List<MoviePreviewDto>,
    val trendingMovies: List<MoviePreviewDto>
)