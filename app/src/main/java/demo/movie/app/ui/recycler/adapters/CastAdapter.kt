package demo.movie.app.ui.recycler.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import demo.movie.app.R
import demo.movie.app.di.DaggerAppComponent
import demo.movie.app.model.dto.CastMemberDto
import demo.movie.app.ui.recycler.callbacks.CastDiffUtilCallback
import demo.movie.app.ui.recycler.callbacks.MovieDiffUtilCallback
import demo.movie.app.util.image.BaseImageLoader
import demo.movie.app.util.image.ImageSize
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.cast_member_card.view.*

class CastAdapter(
    private val onItemClickListener: (CastMemberDto) -> Unit,
    private val imageLoader: BaseImageLoader
) : RecyclerView.Adapter<CastAdapter.CastViewHolder>() {

    private var items: List<CastMemberDto> = listOf()

    fun updateItems(newData: List<CastMemberDto>) {
        val diffCallback = CastDiffUtilCallback(oldList = items, newList = newData)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        items = newData
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastViewHolder {
        val castMemberCard = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.cast_member_card, parent, false) as CardView
        return CastViewHolder(castMemberCard, onItemClickListener)
    }

    override fun onBindViewHolder(holder: CastViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int =
        items.size

    inner class CastViewHolder(
        override val containerView: View,
        onItemClickListener: (CastMemberDto) -> Unit
    ) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        init {
            DaggerAppComponent.builder()

            containerView.setOnClickListener {
                onItemClickListener(items[adapterPosition])
            }
        }

        fun bind(castMember: CastMemberDto) {

            val imageRawPath = castMember.profile_path
            if (imageRawPath != null)
                imageLoader.loadImagePoster(
                    viewWith = containerView,
                    imageRawPath = imageRawPath,
                    imageSize = ImageSize.W500,
                    viewInto = containerView.cast_member_photo_iv
                )

            containerView.cast_member_name_tv.text = castMember.name
            containerView.cast_member_role_tv.text = castMember.character
        }
    }
}