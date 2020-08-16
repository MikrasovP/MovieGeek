package demo.movie.app.util

fun convertToRating(value: Double) : Int {
    //we receive 1..10 from server and we need 1..100 for CircleRatingView
    val coefficient = 10
    return (value * coefficient).toInt()
}