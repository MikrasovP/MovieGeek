package demo.movie.app.ui.recycler.callbacks

import androidx.recyclerview.widget.DiffUtil
import demo.movie.app.model.dto.tv.TvPreviewDto

class TvDiffUtilCallback(
    private val oldList: List<TvPreviewDto>,
    private val newList: List<TvPreviewDto>
) : DiffUtil.Callback() {
    override fun areItemsTheSame(oldPos: Int, newPos: Int): Boolean =
        oldList[oldPos].id == newList[newPos].id

    override fun areContentsTheSame(oldPos: Int, newPos: Int): Boolean =
        oldList[oldPos] == newList[newPos]

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size
}