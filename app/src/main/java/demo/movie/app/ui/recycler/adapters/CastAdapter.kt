package demo.movie.app.ui.recycler.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import demo.movie.app.R
import demo.movie.app.di.DaggerAppComponent
import demo.movie.app.model.dto.CastMemberDto
import demo.movie.app.model.dto.CrewMemberDto
import demo.movie.app.model.dto.movie.MoviePreviewDto
import demo.movie.app.util.RatingConverter
import demo.movie.app.util.image.BaseImageLoader
import demo.movie.app.util.image.ImageSize
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.movie_card.view.*

class CastAdapter(
    private val onItemClickListener: (CastMemberDto) -> Unit,
    private val imageLoader: BaseImageLoader
) : RecyclerView.Adapter<CastAdapter.CastViewHolder>() {

    private var items: List<CastMemberDto> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastViewHolder {
        val castMemberCard = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.cast_member_card, parent, false) as CardView
        return CastViewHolder(castMemberCard, onItemClickListener)
    }

    override fun onBindViewHolder(holder: CastViewHolder, position: Int) {
        TODO("Not yet implemented")
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

            imageLoader.loadImagePoster(
                viewWith = containerView,
                imageRawPath = movie.posterPath,
                imageSize = ImageSize.W500,
                viewInto = containerView.iv_movie_card_poster
            )

            containerView.tv_movie_card_title.text = movie.title
            containerView.tv_movie_card_date.text = movie.releaseDate
            containerView.tv_movie_card_adult_label.visibility =
                if (movie.isAdult) View.VISIBLE else View.GONE
            containerView.tv_movie_card_rating_label.setRating(
                RatingConverter.convertFromServerFormatToLocal(movie.voteAverage)
            )
        }
    }
}