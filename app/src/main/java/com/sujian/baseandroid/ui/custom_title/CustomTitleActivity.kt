package com.sujian.baseandroid.ui.custom_title

import android.graphics.Color
import android.support.design.widget.TabLayout
import com.sujian.baseandroid.R
import com.sujian.baseandroid.adapter.FragmentAdapger
import com.sujian.baseandroid.base.activity.BaseTitleActivity
import kotlinx.android.synthetic.main.activity_custom_title.*

class CustomTitleActivity : BaseTitleActivity() {

    override fun getTitleText(): String = "自定义Title"
    override fun getLayoutResId(): Int = R.layout.activity_custom_title

    override fun initView() {
        mToolbar?.setRightVisiable(false)



        val titles = arrayOf("aaa","bbb")
        val fragments = arrayOf(OneFragment.newInstance(),TwoFragment.newInstance())


        custom_viewpage.adapter = FragmentAdapger(supportFragmentManager,titles,fragments)

//        custom_tablayout.setupWithViewPager(custom_viewpage)


        val tablayout = TabLayout(this)

        tablayout.setupWithViewPager(custom_viewpage)
        tablayout.tabMode = TabLayout.MODE_SCROLLABLE
        tablayout.setTabTextColors(Color.GRAY,Color.WHITE)
        tablayout.setSelectedTabIndicatorColor(Color.WHITE)
        mToolbar?.setCustomView(tablayout)


    }







}
