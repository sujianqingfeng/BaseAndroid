package com.sujian.baseandroid.widgets

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View


/**
 *   author: sujian
 *   date: 2018/8/28
 *   desc: xxx
 */
class TembinView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {


    var mPaint: Paint? = null
    var centerX: Float = 0f
    var centerY: Float = 0f

    lateinit var start: PointF
    lateinit var end: PointF
    lateinit var control: PointF
    lateinit var control1: PointF
    lateinit var control2: PointF


    init {
        mPaint = Paint()
        mPaint?.color = Color.BLACK
        mPaint?.strokeWidth = 8f
        mPaint?.style = Paint.Style.STROKE
        mPaint?.textSize = 8f


        start = PointF(0f, 0f)
        end = PointF(0f, 0f)
        control = PointF(0f, 0f)
        control1 = PointF(0f, 0f)
        control2 = PointF(0f, 0f)
    }


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        centerX = w.toFloat() / 2
        centerY = h.toFloat() / 2



    }

//
//    override fun onTouchEvent(event: MotionEvent): Boolean {
//        // 根据触摸位置更新控制点，并提示重绘
//        control.x = event.x
//        control.y = event.y
//        invalidate()
//        return true
//    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        // 绘制数据点和控制点
//        mPaint?.color = Color.GRAY
//        mPaint?.strokeWidth = 20f
//        canvas?.drawPoint(start.x, start.y, mPaint)
//        canvas?.drawPoint(end.x, end.y, mPaint)
//        canvas?.drawPoint(control.x, control.y, mPaint)
//
//        // 绘制辅助线
//        mPaint?.strokeWidth = 4f
//        canvas?.drawLine(start.x, start.y, control.x, control.y, mPaint)
//        canvas?.drawLine(end.x, end.y, control.x, control.y, mPaint)
//
//        // 绘制贝塞尔曲线
//        mPaint?.color = Color.BLUE
//        mPaint?.strokeWidth = 8f

        val path = Path()


        start.x = centerX - 200
        start.y = centerY
        end.x = centerX + 200
        end.y = centerY

        control.x = centerX + 50
        control.y = centerY - 150


        control1.x = centerX + 50
        control1.y = centerY + 50

        control2.x = centerX
        control2.y = centerY - 80


        path.moveTo(start.x, start.y)
        path.quadTo(control.x, control.y, end.x, end.y)
        path.cubicTo(control1.x, control1.y, control2.x,control2.y, start.x, start.y);


        val  path2 = Path()

        path.moveTo(0f,0f)
        path2.cubicTo(200f,10f,200f,150f,400f,200f)




        canvas?.drawPath(path, mPaint)
        canvas?.drawPath(path2, mPaint)
    }


}