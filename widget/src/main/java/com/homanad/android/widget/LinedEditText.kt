package com.homanad.android.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText

class LinedEditText
@JvmOverloads constructor(
    context: Context, attrs: AttributeSet?, defStyle: Int = R.attr.editTextStyle
) : AppCompatEditText(context, attrs, defStyle) {

    companion object {
        private const val DEFAULT_SHOW_LINE = true
        private const val DEFAULT_LINE_WIDTH = 1 //px
        private val DEFAULT_DASH_WIDTH = 2.dp
        private val DEFAULT_DASH_GAP = 2.dp
        private val DEFAULT_DOT_SPACE = 5.dp
        private val DEFAULT_LINE_SPACING_EXTRA = 2.dp

        private const val DEFAULT_PHRASE = 1f
    }

    private var mIsShowLines = DEFAULT_SHOW_LINE
    private var mLineColor: Int = Color.BLACK
    private var mLineWidth: Int = DEFAULT_LINE_WIDTH
    private var mDashWidth: Int = 0
    private var mDashGap: Int = 0
    private var mLineStyle: Int = LineStyle.STROKE.ordinal
    private var mDotSpace: Int = 0
    private var mLineSpacingExtra: Int = 0

    private val mRect: Rect = Rect()
    private val mPaint: Paint = Paint()

    init {
        val ta = context.obtainStyledAttributes(attrs, R.styleable.LinedEditText, defStyle, 0)

        mIsShowLines = ta.getBoolean(R.styleable.LinedEditText_let_showLines, DEFAULT_SHOW_LINE)
        mLineColor = ta.getColor(R.styleable.LinedEditText_let_lineColor, mLineColor)
        mLineWidth = ta.getDimensionPixelSize(R.styleable.LinedEditText_let_lineWidth, DEFAULT_LINE_WIDTH)
        mDashWidth = ta.getDimensionPixelSize(R.styleable.LinedEditText_let_dashWidth, 0)
        mDashGap = ta.getDimensionPixelSize(R.styleable.LinedEditText_let_dashGap, 0)
        mLineStyle = ta.getInt(R.styleable.LinedEditText_let_lineStyle, LineStyle.STROKE.ordinal)
        mDotSpace = ta.getDimensionPixelSize(R.styleable.LinedEditText_let_dotSpace, DEFAULT_DOT_SPACE)
        mLineSpacingExtra =
            ta.getDimensionPixelSize(R.styleable.LinedEditText_let_lineSpacingExtra, DEFAULT_LINE_SPACING_EXTRA)

        ta.recycle()
    }

    private fun createLineStyle() {
        when (mLineStyle) {
            LineStyle.DASH.ordinal -> createAndSetDashPathEffect(
                if (mDashWidth == 0) DEFAULT_DASH_WIDTH else mDashWidth,
                if (mDashGap == 0) DEFAULT_DASH_GAP else mDashGap
            )
            LineStyle.DOT.ordinal -> createAndSetDashPathEffect(mLineWidth, mDotSpace)
            else -> if (mDashWidth != 0 && mDashGap != 0) createAndSetDashPathEffect(mDashWidth, mDashGap)
        }
    }

    private fun createAndSetDashPathEffect(dashWidth: Int, dashGap: Int) {
        mPaint.pathEffect = DashPathEffect(
            floatArrayOf(dashWidth.toFloat(), dashGap.toFloat()),
            DEFAULT_PHRASE
        )
    }

    private fun setupPaint() {
        mPaint.apply {
            color = mLineColor
            strokeWidth = mLineWidth.toFloat()
        }
    }

    var isShowLines: Boolean
        get() = mIsShowLines
        set(value) {
            if (value == mIsShowLines) {
                return
            }
            mIsShowLines = value
            invalidate()
        }

    var lineColor: Int
        get() = mLineColor
        set(value) {
            if (value == mLineColor) {
                return
            }
            mLineColor = value
            invalidate()
        }

    var lineWidth: Int
        get() = mLineWidth
        set(value) {
            if (value == mLineWidth) {
                return
            }
            mLineWidth = value
            invalidate()
        }

    var dashWidth: Int
        get() = mDashWidth
        set(value) {
            if (value == mDashWidth) {
                return
            }
            mDashWidth = value
            invalidate()
        }

    var dashGap: Int
        get() = mDashGap
        set(value) {
            if (value == mDashGap) {
                return
            }
            mDashGap = value
            invalidate()
        }

    var lineStyle: LineStyle
        get() = when (mLineStyle) {
            LineStyle.STROKE.ordinal -> LineStyle.STROKE
            LineStyle.DASH.ordinal -> LineStyle.DASH
            LineStyle.DOT.ordinal -> LineStyle.DOT
            else -> LineStyle.STROKE
        }
        set(value) {
            if (value.ordinal == mLineStyle) {
                return
            }
            mLineStyle = value.ordinal
            invalidate()
        }

    var dotSpace
        get() = mDotSpace
        set(value) {
            if (value == mDotSpace) return
            mDotSpace = value
            invalidate()
        }

    var lineSpacingExtra
        get() = mLineSpacingExtra
        set(value) {
            if (value == mLineSpacingExtra) return
            mLineSpacingExtra = value
            invalidate()
        }

    override fun onDraw(canvas: Canvas) {
        if (mIsShowLines) {
            createLineStyle()
            setupPaint()

            var count = height / lineHeight
            if (lineCount > count) count = lineCount
            var baseline = getLineBounds(0, mRect)
            for (i in 0 until count) {
                canvas.drawLine(
                    mRect.left.toFloat(),
                    (baseline + mLineSpacingExtra).toFloat(),
                    mRect.right.toFloat(),
                    (baseline + mLineSpacingExtra).toFloat(),
                    mPaint
                )
                baseline += lineHeight
            }
        }

        super.onDraw(canvas)
    }

    enum class LineStyle {
        STROKE, DASH, DOT
    }
}