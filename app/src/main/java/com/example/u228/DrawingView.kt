package com.example.u228

import android.content.Context
import android.content.res.Resources
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RectShape
import android.util.AttributeSet
import android.view.View

class DrawingView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }

    fun drawTemp(temperature: Int) {
        val temp = (temperature + 100).toFloat() / 200

        println(temperature)
        println(temp)
        println("${0} ${height * temp} $width $height")
        val createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(createBitmap)

        //aizkrāsojam mūsu canvas ar baltu krāsu
        val shape = ShapeDrawable(RectShape())
        shape.setBounds(0, 0, width, height)
        shape.paint.color = Color.WHITE
        shape.draw(canvas)

        // zīmējam "dzīvsudraba" daļu
        shape.setBounds(0, height - (height * temp).toInt(), width, height)
        shape.paint.color = Color.parseColor("#d9b2a9")
        shape.draw(canvas)

        background = BitmapDrawable(resources, createBitmap)
    }

}