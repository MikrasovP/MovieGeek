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
import demo.movie.app.R
import demo.movie.app.model.dto.MoviePreviewDto
import demo.movie.app.ui.discover.recycler.MovieDiffUtilCallback

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

        private val poster : ImageView = movieCard.findViewById(R.id.iv_movie_card_poster)
        private val title : TextView = movieCard.findViewById(R.id.tv_movie_card_title)
        private val date : TextView = movieCard.findViewById(R.id.tv_movie_card_date)
        private val popularity : TextView = movieCard.findViewById(R.id.tv_movie_card_popularity)
        private val adultLabel : TextView = movieCard.findViewById(R.id.tv_movie_card_adult_label)

        init {
            movieCard.setOnClickListener {
                onItemClickListener(items[adapterPosition])
            }
        }

        fun bind(movie: MoviePreviewDto) {
            //Glide encapsulates such logic, so it's better to remove this "if"
            if (movie.poster_path != "")
                Glide.with(movieCard).load(movie.poster_path).into(poster)
            title.text = movie.name
            date.text = movie.firs_air_date
            popularity.text = movie.popularity.toString()
            adultLabel.visibility = if (movie.adult) View.VISIBLE else View.GONE
        }
    }

}