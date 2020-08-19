package demo.movie.app.ui.discover.recycler.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import demo.movie.app.R
import demo.movie.app.model.dto.MoviePreviewDto
import demo.movie.app.ui.custom.CircleRatingView
import demo.movie.app.ui.discover.recycler.MovieDiffUtilCallback
import demo.movie.app.util.Constants
import demo.movie.app.util.RatingConverter

class MovieAdapter(
    private val onItemClickListener: (MoviePreviewDto) -> Unit
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
        private val movieCard: CardView,
        onItemClickListener: (MoviePreviewDto) -> Unit
    ) : RecyclerView.ViewHolder(movieCard) {

        private val poster: ImageView = movieCard.findViewById(R.id.iv_movie_card_poster)
        private val title: TextView = movieCard.findViewById(R.id.tv_movie_card_title)
        private val date: TextView = movieCard.findViewById(R.id.tv_movie_card_date)
        private val adultLabel: TextView = movieCard.findViewById(R.id.tv_movie_card_adult_label)
        private val ratingLabel: CircleRatingView =
            movieCard.findViewById(R.id.tv_movie_card_rating_label)

        init {
            movieCard.setOnClickListener {
                onItemClickListener(items[adapterPosition])
            }
        }

        fun bind(movie: MoviePreviewDto) {
            val requestOption = RequestOptions()
                .placeholder(R.drawable.card_poster_fallback)
                .fallback(R.drawable.card_poster_fallback)
                .error(R.drawable.card_poster_fallback)

            //TODO: fix image loading, move it out
            Glide.with(movieCard)
                .load(Constants.BASE_URL.dropLast(1) + movie.poster_path)
                .transition(DrawableTransitionOptions.withCrossFade())
                .apply(requestOption)
                .into(poster)
            title.text = movie.name
            date.text = movie.firs_air_date
            adultLabel.visibility = if (movie.adult) View.VISIBLE else View.GONE
            ratingLabel.setRating(
                RatingConverter.convertFromServerFormatToLocal(movie.voteAverage)
            )
        }
    }

}