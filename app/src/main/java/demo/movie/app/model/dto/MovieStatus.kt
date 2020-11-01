package demo.movie.app.model.dto

enum class MovieStatus(val string: String) {
    RUMORED("Rumored"),
    PLANNED("Planned"),
    IN_PRODUCTION("In Production"),
    POST_PRODUCTION("Post Production"),
    RELEASED("Released"),
    CANCELLED("Cancelled")
}