package com.homanad.android.linededittext

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.homanad.android.widget.LinedEditText
import com.homanad.android.widget.dp

class MainActivity : AppCompatActivity() {

    private val linedEditText by lazy {
        findViewById<LinedEditText>(R.id.lined_edit_text)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        linedEditText.dashGap = 20.dp
//        linedEditText.dashWidth = 20
//        linedEditText.lineWidth = 5
//        linedEditText.lineColor = Color.RED
//        linedEditText.isShowLines = true
//        linedEditText.lineStyle = LinedEditText.LineStyle.DASH
//        linedEditText.lineStyle = LinedEditText.LineStyle.DOT
//        linedEditText.dotSpace = 5
//        linedEditText.lineSpacingExtra = 10
    }
}