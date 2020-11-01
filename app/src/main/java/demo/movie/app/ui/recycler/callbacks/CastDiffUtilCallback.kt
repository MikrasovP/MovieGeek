package demo.movie.app.ui.recycler.callbacks

import androidx.recyclerview.widget.DiffUtil
import demo.movie.app.model.dto.CastMemberDto

class CastDiffUtilCallback(
    private val oldList: List<CastMemberDto>,
    private var newList: List<CastMemberDto>,
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int =
        oldList.size

    override fun getNewListSize(): Int =
        newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition] == newList[newItemPosition]

}