package com.sujian.baseandroid.base.activity

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import com.sujian.baseandroid.R
import com.sujian.baseandroid.widgets.SimpleToolbar
import org.jetbrains.anko.backgroundColorResource
import org.jetbrains.anko.dip


/**
 *   author: sujian
 *   date: 2018/8/21
 *   desc: xxx
 */
abstract class BaseTitleActivity : BaseActivity(),SimpleToolbar.ToolbarListener{

    protected var mToolbar:SimpleToolbar?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(getLayoutResId())
        initView()
    }



    override fun setContentView(layoutResID: Int) {
//        mToolbar = SimpleToolbar(this)

        mToolbar = SimpleToolbar.Builder(this)
                .setTitle(getTitleText())
                .setToolbarListener(this)
                .build()

        val rootContainer = LinearLayout(this)
        rootContainer.orientation = LinearLayout.VERTICAL
        val contentContainer = View.inflate(this,layoutResID,null)

        if (isAddToolbar()) rootContainer.addView(mToolbar,LinearLayout.LayoutParams.MATCH_PARENT,dip(75))

        rootContainer.addView(contentContainer,LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT)
        super.setContentView(rootContainer)
        initToolbar()
    }


    fun initToolbar(){
        setSupportActionBar(mToolbar)
        mToolbar?.fitsSystemWindows = true
        mToolbar?.backgroundColorResource = R.color.colorPrimary
//        mToolbar?.setToolbarListener(this)
    }


    override fun onLeftClick() {
        finish()
    }

    override fun onRightClick() {

    }

    /**
     * 如果不需要添加toolbar 覆写此方法即可
     */
    open fun isAddToolbar():Boolean = true

    abstract fun getLayoutResId():Int

    abstract fun initView()

    abstract fun getTitleText():String
}