package com.sujian.baseandroid.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.orhanobut.logger.Logger
import com.sujian.baseandroid.R

/**
 *   author: sujian
 *   date: 2018/8/27
 *   desc: xxx
 */
class StateView @JvmOverloads constructor(resId:Int,context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : FrameLayout(context, attrs, defStyleAttr) {


    private var ladingPage: View? = null
    private var errorPage: View? = null
    private var emptyPage: View? = null
    private var notNetPage: View? = null
    private var contentPage: View? = null


    init {
        emptyPage = LayoutInflater.from(context).inflate(R.layout.widget_state_empty_page, null)
        ladingPage = LayoutInflater.from(context).inflate(R.layout.widget_state_lading_page, null)
        errorPage = LayoutInflater.from(context).inflate(R.layout.widget_state_error_page, null)
        notNetPage = LayoutInflater.from(context).inflate(R.layout.widget_state_not_net_page, null)
        contentPage = LayoutInflater.from(context).inflate(resId, null)

    }



    fun showContentView(){
        removeAllViews()
        addView(contentPage)
    }

    fun showEmptyView() {
        removeAllViews()
        addView(emptyPage)
    }

    fun showLadingView(){
        removeAllViews()
        addView(ladingPage)
    }

    fun showErrorView(){
        addView(errorPage)
    }

    fun showNotNetPage(){
        removeAllViews()
        addView(notNetPage)
    }


}