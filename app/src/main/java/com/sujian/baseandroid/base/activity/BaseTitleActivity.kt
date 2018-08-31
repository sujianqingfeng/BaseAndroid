package com.sujian.baseandroid.base.activity

import android.os.Bundle
import android.transition.Explode
import android.view.View
import android.widget.LinearLayout
import com.sujian.baseandroid.R
import com.sujian.baseandroid.widgets.EasyToolbar
import org.jetbrains.anko.backgroundColorResource
import org.jetbrains.anko.dip


/**
 *   author: sujian
 *   date: 2018/8/21
 *   desc: xxx
 */
abstract class BaseTitleActivity : BaseActivity(), EasyToolbar.ToolbarListener {

    protected var mToolbar: EasyToolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(getLayoutResId())

        window.enterTransition = Explode().setDuration(500)
        window.exitTransition = Explode().setDuration(500)
        initView()
    }


    override fun setContentView(layoutResID: Int) {
//        mToolbar = SimpleToolbar(this)

        mToolbar = EasyToolbar.Builder(this)
                .setTitle(getTitleText())
                .setToolbarListener(this)
                .build()

        val rootContainer = LinearLayout(this)
        rootContainer.orientation = LinearLayout.VERTICAL
        val contentContainer = View.inflate(this, layoutResID, null)

        if (isAddToolbar()) rootContainer.addView(mToolbar, LinearLayout.LayoutParams.MATCH_PARENT, dip(75))

        rootContainer.addView(contentContainer, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
        super.setContentView(rootContainer)
        initToolbar()
    }


    fun initToolbar() {
        setSupportActionBar(mToolbar)
        mToolbar?.fitsSystemWindows = true
        mToolbar?.backgroundColorResource = R.color.colorPrimary
//        mToolbar?.setToolbarListener(this)
    }


    override fun onLeftClick(view:View) {
        finish()
    }

    override fun onRightClick(view:View) {

    }

    /**
     * 如果不需要添加toolbar 覆写此方法即可
     */
    open fun isAddToolbar(): Boolean = true

    abstract fun getLayoutResId(): Int

    abstract fun initView()

    abstract fun getTitleText(): String
}