package demo.movie.app.model.services

import demo.movie.app.BuildConfig
import demo.movie.app.model.api.MoviesApi
import demo.movie.app.model.dto.MoviePreviewDto
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.core.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkService {
    companion object{
        private const val BASE_URL = "https://api.themoviedb.org/3"
        private const val API_KEY = BuildConfig.TMDB_API_V3_KEY
    }

    private val retrofit: Retrofit
    private val moviesApi: MoviesApi

    init {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpClient.Builder().addInterceptor(interceptor).build())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
        moviesApi = retrofit.create(MoviesApi::class.java)
    }

    fun getPopularMovies(): Observable<List<MoviePreviewDto>> =
        moviesApi.getPopular(API_KEY)

    fun getTrendingPerWeek(): Observable<List<MoviePreviewDto>> =
        moviesApi.getTrendingPerWeek(API_KEY)

    fun getTrendingPerDay(): Observable<List<MoviePreviewDto>> =
        moviesApi.getTrendingPerDay(API_KEY)

    fun getTopRated(): Observable<List<MoviePreviewDto>> =
        moviesApi.getTopRated(API_KEY)

}