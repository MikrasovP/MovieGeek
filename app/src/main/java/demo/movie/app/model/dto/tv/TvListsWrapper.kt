package demo.movie.app.model.dto.tv

data class TvListsWrapper(
    val topRated: List<TvPreviewDto>,
    val popular: List<TvPreviewDto>,
    val trending: List<TvPreviewDto>
)