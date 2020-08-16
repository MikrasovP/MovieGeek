package demo.movie.app.util

/**
 * Converts between
 *      server format rating data (double, 0.1-10)
 *      and CircleRatingView format (int, 1-100)
 */
class RatingConverter {
    companion object {

        private const val COEFFICIENT = 10
        private const val EPSILON = 0.00001

        /**
         * @throws IllegalArgumentException - argument must fits to server format range
         * @param value - server format data (0.1-10)
         * @return CircleRatingView format (int, 1-100)
         */
        fun convertFromServerFormatToLocal(value: Double) : Int {

            if(value < (0.1 - EPSILON) ||
                value > (10.toDouble() + EPSILON))
                throw IllegalArgumentException()

            return (value * COEFFICIENT).toInt()
        }

        /**
        * @throws IllegalArgumentException - argument must fits to local format range
        * @param value - CircleRatingView format (int, 1-100)
        * @return server format data (0.1-10)
        */
        fun convertFromLocalFormatToServer(value: Int) : Double {

            if(value < 1 || value > 100)
                throw IllegalArgumentException()

            return value.toDouble() / COEFFICIENT
        }


    }
}