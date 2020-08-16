package demo.movie.app.ui.custom

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import demo.movie.app.R

class CircleRatingView
@JvmOverloads
constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    companion object {
        private const val DEFAULT_RATING = 0
        private const val DEFAULT_STRIP_WIDTH = 2f
        private const val DEFAULT_STRIP_SPACE = 4f
        private const val DEFAULT_BACK_COLOR = Color.BLACK
        private const val DEFAULT_TEXT_COLOR = Color.WHITE
    }

    private var ovalPaint: Paint
    private var stripPaint: Paint
    private var textPaint: Paint

    private var ovalRect = RectF()
    private var stripRect = RectF()

    private var rating = DEFAULT_RATING
    private var stripWidth = DEFAULT_STRIP_WIDTH
    private var stripSpace = DEFAULT_STRIP_SPACE
    private var backColor = DEFAULT_BACK_COLOR
    private var textColor = DEFAULT_TEXT_COLOR

    init {
        if (attrs != null) {
            context.obtainStyledAttributes(attrs, R.styleable.CircleRatingView).apply {
                stripWidth = getDimension(
                    R.styleable.CircleRatingView_strip_width,
                    DEFAULT_STRIP_WIDTH
                )
                stripSpace = getDimension(
                    R.styleable.CircleRatingView_strip_space,
                    DEFAULT_STRIP_SPACE
                )
                backColor = getColor(
                    R.styleable.CircleRatingView_back_color,
                    DEFAULT_BACK_COLOR
                )
                textColor = getColor(
                    R.styleable.CircleRatingView_text_color,
                    DEFAULT_BACK_COLOR
                )
                rating = getInteger(
                    R.styleable.CircleRatingView_rating,
                    DEFAULT_RATING
                )
                recycle()
            }
        }

        ovalPaint = Paint().apply {
            color = backColor
            isAntiAlias = true
        }
        stripPaint = Paint().apply {
            isAntiAlias = true
            style = Paint.Style.STROKE
            color = getStripColor(rating)
            strokeWidth = stripWidth
        }
        textPaint = Paint().apply {
            color = textColor
            isAntiAlias = true
            isFakeBoldText = true
            style = Paint.Style.FILL
            textAlign = Paint.Align.CENTER
        }
    }

    override fun onDraw(canvas: Canvas?) {
        ovalRect.apply {
            left = 0F
            top = 0F
            right = this@CircleRatingView.width.toFloat()
            bottom = this@CircleRatingView.height.toFloat()
        }
        stripRect.apply {
            left = stripSpace
            top = stripSpace
            right = this@CircleRatingView.width - stripSpace
            bottom = this@CircleRatingView.height - stripSpace
        }
        textPaint.textSize = height / 3F

        canvas?.drawOval(ovalRect, ovalPaint)
        canvas?.drawText(
            "$rating%",
            width / 2F,
            height / 2F + textPaint.textSize / 2.5F,
            textPaint
        )
        stripPaint.alpha = 125
        canvas?.drawArc(
            stripRect,
            0F,
            360F,
            false,
            stripPaint
        )
        stripPaint.alpha = 255
        canvas?.drawArc(
            stripRect,
            -90F,
            (3.6 * rating).toFloat(),
            false,
            stripPaint
        )
    }

    private fun getStripColor(rating: Int): Int {
        return if (rating <= 50) {
            val green = (255F * (rating.toFloat() / 50F)).toInt()
            Color.rgb(255, green, 0)
        } else {
            val red = (255F * (1F - (rating.toFloat() - 50F) / 50F)).toInt()
            Color.rgb(red, 255, 0)
        }
    }

    fun setRating(rating: Int) {
        if (rating in 0..100) {
            this.rating = rating
            stripPaint.color = getStripColor(rating)
        }
    }
}