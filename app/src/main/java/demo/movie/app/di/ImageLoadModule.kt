package demo.movie.app.di

import dagger.Binds
import dagger.Module
import demo.movie.app.util.image.BaseImageLoader
import demo.movie.app.util.image.ImageLoader
import demo.movie.app.util.image.path.BaseImagePathMaker
import demo.movie.app.util.image.path.ImagePathMaker
import javax.inject.Singleton

@Module
interface ImageLoadModule {

    @Singleton
    @Binds
    fun bindImageLoader(imageLoader: ImageLoader): BaseImageLoader

    @Singleton
    @Binds
    fun bindImagePathMaker(imagePathMaker: ImagePathMaker): BaseImagePathMaker

}