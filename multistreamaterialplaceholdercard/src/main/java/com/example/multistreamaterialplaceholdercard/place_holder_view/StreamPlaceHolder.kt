package com.example.multistreamaterialplaceholdercard.place_holder_view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import androidx.core.content.res.ResourcesCompat
import com.example.multistreamaterialplaceholdercard.R

class StreamPlaceHolder : View {

    private lateinit var videoPlaceholderRect: Rect
    private lateinit var userNamePlaceHolderRect: Rect
    private lateinit var titlePlaceHolderRect: Rect
    private lateinit var placeHolderPaint: Paint
    var placeHolderAlpha = 150

    constructor(context: Context?) : super(context) {
        init(context)
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )


    private fun init(context: Context?) {
        setBackgroundColor(
            ResourcesCompat.getColor(
                resources,
                R.color.colorSurface,
                context?.theme
            )
        )
        videoPlaceholderRect = Rect()
        elevation = 10f
        userNamePlaceHolderRect = Rect()
        titlePlaceHolderRect = Rect()
        placeHolderPaint = Paint().apply {
            color = ResourcesCompat.getColor(resources, R.color.colorOnSurface, context?.theme)
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        videoPlaceholderRect.apply {
            top = 0
            bottom = (h * 0.60f).toInt()
            left = 0
            right = w
        }

        val startLeft = (w * 0.25f).toInt()
        userNamePlaceHolderRect.apply {
            top = (h * 0.70f).toInt()
            bottom = (h * 0.80f).toInt()
            left = startLeft
            right = (w * 0.60f).toInt()
        }

        titlePlaceHolderRect.apply {
            top = (h * 0.84f).toInt()
            bottom = (h * 0.91f).toInt()
            left = startLeft
            right = (w * 0.90f).toInt()
        }
    }

    override fun onDraw(canvas: Canvas?) {
        placeHolderPaint.alpha = placeHolderAlpha
        canvas?.drawRect(videoPlaceholderRect, placeHolderPaint)
        canvas?.drawRect(titlePlaceHolderRect, placeHolderPaint)
        canvas?.drawRect(userNamePlaceHolderRect, placeHolderPaint)
        canvas?.drawCircle(width * 0.13f, height * 0.80f, height * 0.10f, placeHolderPaint)
    }
}