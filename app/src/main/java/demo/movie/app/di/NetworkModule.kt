package demo.movie.app.di

import dagger.Module
import dagger.Provides
import demo.movie.app.model.api.MoviesApi
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
class NetworkModule {

    companion object {
        @Singleton
        @Provides
        fun provideNetworkService() = NetworkService()

        @Singleton
        @Provides
        fun provideMoviesApi(retrofit: Retrofit): MoviesApi =
            retrofit.create(MoviesApi::class.java)

        @Singleton
        @Provides
        fun provideRetrofit(interceptor: Interceptor): Retrofit =
            Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
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



}