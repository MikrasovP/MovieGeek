package demo.movie.app.util.image

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import demo.movie.app.R
import demo.movie.app.util.image.path.BaseImagePathMaker
import javax.inject.Inject

class ImageLoader @Inject constructor() : BaseImageLoader {

    @Inject
    lateinit var imagePathMaker: BaseImagePathMaker

    override fun loadImagePoster(
        viewWith: View,
        imageRawPath: String,
        viewInto: ImageView,
        imageSize: ImageSize
    ) {
        loadImageFullPath(
            viewWith,
            imagePathMaker.getImageFullPath(imageRawPath, imageSize),
            viewInto
        )
    }

    private fun loadImageFullPath(viewWith: View, imageFullPath: String, viewInto: ImageView) {
        val requestOption = RequestOptions()
            .placeholder(R.drawable.card_poster_fallback)
            .fallback(R.drawable.card_poster_fallback)
            .error(R.drawable.card_poster_fallback)

        Glide.with(viewWith)
            .load(imageFullPath)
            .transition(DrawableTransitionOptions.withCrossFade())
            .apply(requestOption)
            .into(viewInto)
    }

}