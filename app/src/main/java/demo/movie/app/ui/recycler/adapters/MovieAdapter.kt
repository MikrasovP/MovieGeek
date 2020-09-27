package demo.movie.app.ui.recycler.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import demo.movie.app.R
import demo.movie.app.di.DaggerAppComponent
import demo.movie.app.model.dto.movie.MoviePreviewDto
import demo.movie.app.ui.recycler.callbacks.MovieDiffUtilCallback
import demo.movie.app.util.RatingConverter
import demo.movie.app.util.image.BaseImageLoader
import demo.movie.app.util.image.ImageSize
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.movie_card.view.*

class MovieAdapter(
    private val onItemClickListener: (MoviePreviewDto) -> Unit,
    private val imageLoader: BaseImageLoader
) : RecyclerView.Adapter<MovieAdapter.MoviesViewHolder>() {

    private var items: List<MoviePreviewDto> = listOf()

    fun updateData(data: List<MoviePreviewDto>) {
        val diffCallback = MovieDiffUtilCallback(oldList = items, newList = data)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        items = data
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val movieCard = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.movie_card, parent, false) as CardView
        return MoviesViewHolder(movieCard, onItemClickListener)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class MoviesViewHolder(
        override val containerView: View,
        onItemClickListener: (MoviePreviewDto) -> Unit
    ) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        init {
            DaggerAppComponent.builder()

            containerView.setOnClickListener {
                onItemClickListener(items[adapterPosition])
            }
        }

        fun bind(movie: MoviePreviewDto) {

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