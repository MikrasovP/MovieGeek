package demo.movie.app.ui.recycler.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import demo.movie.app.R
import demo.movie.app.di.DaggerAppComponent
import demo.movie.app.model.dto.tv.TvPreviewDto
import demo.movie.app.ui.recycler.callbacks.TvDiffUtilCallback
import demo.movie.app.util.RatingConverter
import demo.movie.app.util.image.BaseImageLoader
import demo.movie.app.util.image.ImageSize
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.movie_card.view.*

class TvSeriesAdapter(
    private val onItemClickListener: (TvPreviewDto) -> Unit,
    private val imageLoader: BaseImageLoader
) : RecyclerView.Adapter<TvSeriesAdapter.TvSeriesViewHolder>() {

    private var items: List<TvPreviewDto> = listOf()

    fun updateData(data: List<TvPreviewDto>) {
        val diffCallback = TvDiffUtilCallback(oldList = items, newList = data)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        items = data
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvSeriesViewHolder {
        val movieCard = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.movie_card, parent, false) as CardView
        return TvSeriesViewHolder(movieCard, onItemClickListener)
    }

    override fun onBindViewHolder(holder: TvSeriesViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class TvSeriesViewHolder(
        override val containerView: View,
        onItemClickListener: (TvPreviewDto) -> Unit
    ) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        init {
            DaggerAppComponent.builder()

            containerView.setOnClickListener {
                onItemClickListener(items[adapterPosition])
            }
        }

        fun bind(tv: TvPreviewDto) {

            imageLoader.loadImagePoster(
                viewWith = containerView,
                imageRawPath = tv.poster_path,
                imageSize = ImageSize.ORIGINAL,
                viewInto = containerView.iv_movie_card_poster
            )

            containerView.tv_movie_card_title.text = tv.title
            containerView.tv_movie_card_date.text = tv.release_date
            containerView.tv_movie_card_rating_label.setRating(
                RatingConverter.convertFromServerFormatToLocal(tv.voteAverage)
            )
        }
    }

}