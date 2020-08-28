package demo.movie.app.ui.discover.recycler.callbacks

import androidx.recyclerview.widget.DiffUtil
import demo.movie.app.model.dto.movie.MoviePreviewDto

class MovieDiffUtilCallback(
    private val oldList: List<MoviePreviewDto>,
    private val newList: List<MoviePreviewDto>
) : DiffUtil.Callback() {
    override fun areItemsTheSame(oldPos: Int, newPos: Int): Boolean =
        oldList[oldPos].id == newList[newPos].id

    override fun areContentsTheSame(oldPos: Int, newPos: Int): Boolean =
        oldList[oldPos] == newList[newPos]

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size
}