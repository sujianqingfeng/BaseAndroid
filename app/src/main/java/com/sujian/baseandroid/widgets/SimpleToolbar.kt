package com.sujian.baseandroid.widgets

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.AppCompatImageView
import android.support.v7.widget.Toolbar
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.orhanobut.logger.Logger
import com.sujian.baseandroid.R
import org.jetbrains.anko.*
import android.util.TypedValue
import android.content.res.TypedArray






/**
 *   author: sujian
 *   date: 2018/8/21
 *   desc: xxx
 */
class SimpleToolbar @JvmOverloads constructor(builder: Builder, context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : Toolbar(context, attrs, defStyleAttr) {


    private var builder: Builder? = null


    init {
//        View.inflate(context, R.layout.layout_title_bar,this)
        this.builder = builder
        initView()
    }


    override fun setTitle(title: CharSequence?) {
        super.setTitle("")
//        toolbar_title.text = title

    }


    fun setRightVisiable(bool: Boolean) {
//        builder?.rightView?.visibility = if (bool) View.VISIBLE else View.GONE
        if (!bool) removeView(builder?.rightView)
    }

    fun setCustomView(customView: View) {
        removeView(builder?.titleView)
        val titleParams = Toolbar.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        titleParams.gravity = Gravity.CENTER_HORIZONTAL
        customView.layoutParams = titleParams
        addView(customView)
    }

    //
    fun initView() {
        when (builder?.mode) {
            SimpleToolbar.DEFAULT -> {
                builder?.genTitle()
                builder?.titleView?.text = builder?.title
                addView(builder?.titleView)

                builder?.leftView?.setImageResource(builder!!.leftRes)
                builder?.leftView?.setOnClickListener { builder?.toolbarListener?.onLeftClick() }
                addView(builder?.leftView)

                builder?.rightView?.setImageResource(builder!!.rightRes)
                builder?.rightView?.setOnClickListener { builder?.toolbarListener?.onRightClick() }
                addView(builder?.rightView)
            }
            else -> {
            }
        }
    }


    interface ToolbarListener {
        fun onLeftClick()
        fun onRightClick()
    }


    companion object {
        const val DEFAULT: Int = 0
    }


    class Builder(private val context: Context) {
        var mode: Int? = 0
        var title: String? = null
        var titleView: TextView? = null

        var toolbarListener: ToolbarListener? = null

        var leftView: AppCompatImageView? = null
        var leftRes: Int = R.drawable.ic_arrow_back_black_24dp


        var rightView: AppCompatImageView? = null
        var rightRes: Int = R.mipmap.ic_launcher


        init {
            leftView = AppCompatImageView(context)
            val leftParams = Toolbar.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            leftParams.gravity = Gravity.LEFT
            leftParams.margin = context.dip(16)
            leftView?.layoutParams = leftParams

            val typedValue = TypedValue()
            context.theme
                    .resolveAttribute(android.R.attr.selectableItemBackgroundBorderless, typedValue, true)
            leftView?.backgroundResource = typedValue.resourceId



            rightView = AppCompatImageView(context)
            val rightParams = Toolbar.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            rightParams.gravity = Gravity.RIGHT
            rightParams.topMargin = context.dip(8)
            rightParams.bottomMargin = context.dip(8)
            rightView?.layoutParams = rightParams
            rightView?.backgroundResource = typedValue.resourceId
        }

        fun genTitle() {
            titleView = TextView(context)
            val titleParams = Toolbar.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            titleParams.gravity = Gravity.CENTER_HORIZONTAL
            titleView?.layoutParams = titleParams
            titleView?.gravity = Gravity.CENTER
            titleView?.textColor = Color.WHITE
            titleView?.textSize = context.sp(5).toFloat()
        }

        fun setTitle(title: String): Builder {
            this.title = title
            return this
        }

        fun setToolbarListener(toolbarListener: ToolbarListener): Builder {
            this.toolbarListener = toolbarListener
            return this
        }

        fun setLeftRes(resId: Int): Builder {
            leftRes = resId
            return this
        }

        fun setRightRes(resId: Int): Builder {
            rightRes = resId
            return this
        }

        fun build(): SimpleToolbar = SimpleToolbar(this, context)

    }


}