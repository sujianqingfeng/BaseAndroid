package com.sujian.baseandroid.ui.home

import android.util.TypedValue
import com.orhanobut.logger.Logger
import com.sujian.baseandroid.R
import com.sujian.baseandroid.base.activity.BaseMvpTitleActivity
import com.sujian.baseandroid.data.bean.HomeBean
import com.sujian.baseandroid.ui.custom_title.CustomTitleActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class HomeActivity : BaseMvpTitleActivity<HomePresenter>(),HomeContract.View {


    override fun getTitleText(): String  = "首页"
    override fun initPresenter()= HomePresenter(this)
    override fun getLayoutResId() = R.layout.activity_main


    override fun initView() {

    }

    override fun showText(bean: HomeBean) {
        tv_text.text = bean.data.datas.first().chapterName
    }

    override fun onRightClick() {
        startActivity<CustomTitleActivity>()
    }




}
