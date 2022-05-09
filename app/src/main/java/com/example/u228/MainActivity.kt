package com.example.u228

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)



        val canvas = Canvas()
        val paint = Paint()
        val teal = getColor(R.color.teal)
        paint.color = teal

        canvas.drawRect(0F, 0F, 100F, 100F, paint)
    }

    fun onButtonPressed() {

    }



}