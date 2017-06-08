package com.reactivemobile.kotlinsandbox

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.support.v4.content.ContextCompat.getColor
import android.util.AttributeSet
import android.view.View

class DrawingView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    var radius: Float = 10f
    var path: Path = Path()

    val RADIUS_MULTIPLIER = 20f

    private val paint: Paint = Paint()

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        paint.strokeWidth = 4f
        paint.style = Paint.Style.FILL
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.translate(width / 2 - radius / 2, height / 2 - radius / 2)

        paint.color = getColor(context, R.color.middle)

        path.reset()
        path.moveTo(radius / 2, 0f)
        path.lineTo(radius, 0f)
        path.lineTo(0f, radius)
        path.lineTo(0f, radius)
        path.lineTo(0f, radius / 2)
        canvas?.drawPath(path, paint)

        paint.color = getColor(context, R.color.top_bottom)

        path.reset()
        path.moveTo(0f, 0f)
        path.lineTo(radius / 2, 0f)
        path.lineTo(0f, radius / 2)
        path.lineTo(0f, 0f)
        canvas?.drawPath(path, paint)

        path.reset()
        path.moveTo(0f, radius)
        path.lineTo(radius, radius)
        path.lineTo(radius / 2, radius / 2)
        path.lineTo(0f, radius)
        canvas?.drawPath(path, paint)

        super.onDraw(canvas)
    }

    fun setRadius(percentage: Int){
        radius = percentage * RADIUS_MULTIPLIER
        invalidate()
    }
}