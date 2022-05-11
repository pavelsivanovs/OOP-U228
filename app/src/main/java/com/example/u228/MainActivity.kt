package com.example.u228

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    // Delegated properties
    private val drawingView: DrawingView by lazy { findViewById(R.id.drawingView) }
    private val label: TextView by lazy { findViewById(R.id.label) }
    private val seekBar: SeekBar by lazy { findViewById(R.id.seekBar) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // slaidņa notikumu apstrāde
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            // tiek izsaukts katru reizi, kad slaidņa vērtība (progress) mainās
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                label.text = getString(R.string.temperature, p1)
                p2.let { drawingView.drawTemp(p1) }
            }

            // tiek izsaukts, kad lietotājs sāka mainīt slaidņa vērtību
            override fun onStartTrackingTouch(p0: SeekBar?) {}

            // tiek izsaukts, kad lietotājs beidza mainīt slaidņa vērtību
            override fun onStopTrackingTouch(p0: SeekBar?) {
                p0?.progress?.let { drawingView.drawTemp(it) }
            }
        })
    }
}