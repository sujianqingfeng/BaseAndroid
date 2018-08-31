package com.sujian.baseandroid.ui.home

import android.content.Intent
import android.transition.Explode
import android.transition.Slide
import android.util.TypedValue
import android.view.View
import com.orhanobut.logger.Logger
import com.sujian.baseandroid.R
import com.sujian.baseandroid.base.activity.BaseMvpTitleActivity
import com.sujian.baseandroid.data.bean.HomeBean
import com.sujian.baseandroid.ui.custom_title.CustomTitleActivity
import com.sujian.baseandroid.ui.popup.PopupActivity
import com.sujian.baseandroid.ui.tembin.TembinActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class HomeActivity : BaseMvpTitleActivity<HomePresenter>(),HomeContract.View {


    override fun getTitleText(): String  = "首页"
    override fun initPresenter()= HomePresenter(this)
    override fun getLayoutResId() = R.layout.activity_main


    override fun initView() {
        home_bt_tembin.setOnClickListener { startActivity<TembinActivity>() }

        home_bt_pop.setOnClickListener { startNextActivity(PopupActivity::class.java) }
    }

    override fun showText(bean: HomeBean) {
        tv_text.text = bean.data.datas.first().chapterName
    }

    override fun onRightClick(view: View) {

        startActivity<CustomTitleActivity>()
    }




}
