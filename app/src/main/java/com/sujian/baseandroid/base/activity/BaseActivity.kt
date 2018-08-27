package com.sujian.baseandroid.base.activity

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import com.sujian.baseandroid.base.contract.BaseContract


/**
 *   author: sujian
 *   date: 2018/8/20
 *   desc: xxx
 */
open class BaseActivity: RxAppCompatActivity(),BaseContract.IBaseView {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initWindos()
    }


    private fun initWindos() {

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS or WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT
        } else {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }
    }


    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun showMsg(msg: String) {
    }

    override fun showEmptyView() {
    }

    override fun showNotNetView() {
    }

    override fun showContenView() {
    }


}