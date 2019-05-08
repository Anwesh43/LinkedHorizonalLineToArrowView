package com.anwesh.uiprojects.horizontallinetoarrowview

/**
 * Created by anweshmishra on 08/05/19.
 */


import android.app.Activity
import android.content.Context
import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.Color
import android.view.View
import android.view.MotionEvent

val nodes : Int = 5
val lines : Int = 2
val scGap : Float = 0.05f
val scDiv : Double = 0.51
val strokeFactor : Int = 90
val sizeFactor : Float = 2.9f
val foreColor : Int = Color.parseColor("#6A1B9A")
val backColor : Int = Color.parseColor("#BDBDBD")
val rotDeg : Float = 45f

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.scaleFactor() : Float = Math.floor(this / scDiv).toFloat()
fun Float.mirrorValue(a : Int, b : Int) : Float {
    val k : Float = scaleFactor()
    return (1 - k) * a.inverse() + k * b.inverse()
}
fun Float.updateValue(dir : Float, a : Int, b : Int) : Float = mirrorValue(a, b) * dir * scGap

fun Canvas.drawRotLine(i : Int, size : Float, sc : Float, paint : Paint) {
    val sf : Float = 1f - 2 * i
    save()
    rotate(rotDeg * sc * sf)
    drawLine(0f, 0f, size * sf, 0f, paint)
    restore()
}

fun Canvas.drawHLTNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    val gap : Float = h / (nodes + 1)
    val size : Float = gap / sizeFactor
    val sc1 : Float = scale.divideScale(0, 2)
    val sc2 : Float = scale.divideScale(1, 2)
    val sf : Float = 1f - 2 * (i % 2)
    paint.color = foreColor
    paint.strokeWidth = Math.min(w, h) / strokeFactor
    paint.strokeCap = Paint.Cap.ROUND
    save()
    translate(w / 2, h / 2 - h / 2 * sc2 * sf)
    scale(1f, 1f - 2 * (i % 2))
    for (j in 0..(lines - 1)) {
        drawRotLine(i, size, sc1, paint)
    }
    restore()
}

class HorizontalLineToArrowView(ctx : Context) : View(ctx) {

    override fun onDraw(canvas : Canvas) {

    }

    override fun onTouchEvent(event : MotionEvent) : Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {

            }
        }
        return true
    }
}