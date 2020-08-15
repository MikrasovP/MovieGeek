package demo.movie.app.ui.discover.adapters

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

class MovieAdapter(
    private val onItemClickListener: (MoviePreviewDto) -> Unit
) : RecyclerView.Adapter<MovieAdapter.MoviesViewHolder>() {

    private var items: List<MoviePreviewDto> = listOf(
        MoviePreviewDto(1, true, 4.5, "Довод", "Tenet", "20 августа 2020", "https://upload.wikimedia.org/wikipedia/ru/5/56/Tenet_%28poster%29.jpg"),
        MoviePreviewDto(2, false, 4.5, "Начало", "Inception", "20 августа 2020", "https://upload.wikimedia.org/wikipedia/ru/b/bc/Poster_Inception_film_2010.jpg"),
        MoviePreviewDto(3, true, 4.5, "Однажды в... Голливуде", "Once upon a time in... Hollywood", "20 августа 2020", "https://kinohod.ru/o/72/ba/72ba9feb-2029-45e5-8e42-9d101df11160.jpg"),
        MoviePreviewDto(4, false, 4.5, "Криминальное чтиво", "Pulp fiction", "20 августа 2020", ""),
        MoviePreviewDto(5, true, 4.5, "Титаник", "Titanic", "20 августа 2020", "https://sun1-14.userapi.com/impf/c824201/v824201969/173424/ayWCFmi538s.jpg?size=200x0&quality=90&sign=b461a01af900c4374512c2b13455c25d&ava=1")
    )

    fun updateData(data: List<MoviePreviewDto>) {
        val diffCallback = object : DiffUtil.Callback() {

            override fun areItemsTheSame(oldPos: Int, newPos: Int): Boolean =
                items[oldPos].id == data[newPos].id

            override fun areContentsTheSame(oldPos: Int, newPos: Int): Boolean =
                items[oldPos].hashCode() == data[newPos].hashCode()

            override fun getOldListSize(): Int = items.size

            override fun getNewListSize(): Int = data.size

        }
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
            if (movie.poster_path != "") Glide.with(movieCard).load(movie.poster_path).into(poster)
            title.text = movie.name
            date.text = movie.firs_air_date
            popularity.text = movie.popularity.toString()
            adultLabel.visibility = if (movie.adult) View.VISIBLE else View.GONE
        }
    }

}