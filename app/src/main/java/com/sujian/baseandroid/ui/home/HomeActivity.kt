package com.sujian.baseandroid.ui.home

import com.sujian.baseandroid.R
import com.sujian.baseandroid.base.activity.BaseMvpTitleActivity
import com.sujian.baseandroid.data.bean.HomeBean
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : BaseMvpTitleActivity<HomePresenter>(),HomeContract.View {


    override fun initPresenter()= HomePresenter(this)
    override fun getLayoutResId() = R.layout.activity_main


    override fun initView() {
        initToolbar(title = "首页")
    }

    override fun showText(bean: HomeBean) {
        tv_text.text = bean.data.datas.first().chapterName
    }




}
