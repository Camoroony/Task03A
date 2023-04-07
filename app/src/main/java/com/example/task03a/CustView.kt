package com.example.task03a

import android.view.View
import android.content.Context
import android.util.AttributeSet
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Paint.Style
import android.graphics.Typeface

public class CustView: View {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
            super(context, attrs, defStyleAttr)

    //circle and text colors
    private val circleCol: Int = Color.RED
    private val labelCol: Int = Color.YELLOW
    private val backCol: Int = Color.rgb(250,0,250)
    //label text
    private val wordsText: String = "Hello World"
    //paint variables
    private var circlePaint: Paint
    private var backPaint: Paint
    private var wordsPaint: Paint
    private var dotPaint: Paint

    private var xSep: Float = 180f
    private var ySep: Float = 175f

    init {
        //paint object for drawing circles in onDraw -- also configure it
        circlePaint = Paint().apply {
            setStyle(Style.FILL)
            setAntiAlias(true)

            //set the paint color using the circle color specified
            setColor(circleCol)
        }

        backPaint = Paint().apply {
            // Set up the paint style
            setStyle(Style.FILL)
            setColor(backCol)
        }

        wordsPaint = Paint().apply {
            setColor(labelCol)

            //set text properties
            setTextAlign(Paint.Align.CENTER)
            setTextSize(100.toFloat())
            setTypeface(Typeface.SANS_SERIF)
        }

        dotPaint = Paint().apply {
            // Controls the size of the dot
            setStrokeWidth(25f)
            setStrokeCap(Paint.Cap.SQUARE)

            //set the paint color
            setColor(Color.GREEN)
        }
    }

    override fun onDraw(canvas: Canvas) {
        //draw the View

        // Background
// Measure the size of the canvas, we could take into account padding here
        val canvasWidth = width.toFloat()
        val canvasHeight = height.toFloat()

// Draw rectangle with drawRect(topleftX, topLeftY, bottomRightX, bottomRightY, Paint)
// Use Ctrl-P to see the parameters for a function
        canvas.drawRect(0f, 0f, canvasWidth, canvasHeight, backPaint)

        // Circle
//get half of the width and height to locate the centre of the screen
        val viewWidthHalf = canvasWidth / 2f
        val viewHeightHalf = canvasHeight / 2f

//get the radius as half of the width or height, whichever is smaller
//subtract twenty so that it has some space around it
        val radius: Float = minOf(viewWidthHalf,viewHeightHalf) - 20

        //canvas.drawCircle(viewWidthHalf, viewHeightHalf, radius, circlePaint)

        // Text
//draw the text using the string attribute and chosen properties
        //canvas.drawText(wordsText, viewWidthHalf, viewHeightHalf, wordsPaint)

        for (x in 1..5) {
            for (y in 1..10) {
                canvas.drawPoint(x*xSep, y*ySep,  dotPaint)
            }
        }
    }


}