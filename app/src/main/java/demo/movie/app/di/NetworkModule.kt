package demo.movie.app.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import demo.movie.app.model.api.MoviesApi
import demo.movie.app.model.api.TvSeriesApi
import demo.movie.app.model.services.BaseNetworkService
import demo.movie.app.model.services.NetworkService
import demo.movie.app.util.Constants
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
abstract class NetworkModule {

    companion object {

        @Singleton
        @Provides
        fun provideMoviesApi(retrofit: Retrofit): MoviesApi =
            retrofit.create(MoviesApi::class.java)

        @Singleton
        @Provides
        fun provideTvSeriesApi(retrofit: Retrofit): TvSeriesApi =
            retrofit.create(TvSeriesApi::class.java)

        @Singleton
        @Provides
        fun provideRetrofit(interceptor: Interceptor): Retrofit =
            Retrofit.Builder()
                .baseUrl(Constants.BASE_API_URL)
                .client(OkHttpClient.Builder().addInterceptor(interceptor).build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()

        @Singleton
        @Provides
        fun provideInterceptor(): Interceptor {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            return interceptor
        }
    }

    @Singleton
    @Binds
    abstract fun bindBaseNetworkService(networkService: NetworkService): BaseNetworkService

}