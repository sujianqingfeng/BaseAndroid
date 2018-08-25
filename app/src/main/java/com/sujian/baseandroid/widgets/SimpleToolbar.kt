package com.sujian.baseandroid.widgets

import android.content.Context
import android.support.v7.widget.Toolbar
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.orhanobut.logger.Logger
import com.sujian.baseandroid.R
import kotlinx.android.synthetic.main.layout_title_bar.view.*
import org.jetbrains.anko.backgroundColorResource


/**
 *   author: sujian
 *   date: 2018/8/21
 *   desc: xxx
 */
class SimpleToolbar @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : Toolbar(context, attrs, defStyleAttr) {


    protected var mToolbarListener:ToolbarListener? = null

    init {
        View.inflate(context, R.layout.layout_title_bar,this)
        initView()
    }


    override fun setTitle(title: CharSequence?) {
        super.setTitle("")
        toolbar_title.text = title
    }




    fun initView(){
        iv_left?.setOnClickListener { mToolbarListener?.onLeftClick() }
        iv_rigth?.setOnClickListener{ mToolbarListener?.onRightClick()}
    }



    fun setToolbarListener(toolbarListener: ToolbarListener){
        mToolbarListener = toolbarListener
    }

    interface ToolbarListener{
        fun onLeftClick()
        fun onRightClick()
    }







}