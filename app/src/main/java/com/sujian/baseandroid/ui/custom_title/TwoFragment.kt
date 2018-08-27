package com.sujian.baseandroid.ui.custom_title

import com.sujian.baseandroid.R
import com.sujian.baseandroid.base.fragment.BaseMvpStateFragment

/**
 *   author: sujian
 *   date: 2018/8/27
 *   desc: xxx
 */
class TwoFragment :BaseMvpStateFragment<OnePresenter>(),OneContract.View{
    override fun initPresenter()  = OnePresenter(this)

    override fun getLayoutResId(): Int  = R.layout.fragment_two


    companion object {
        fun newInstance():TwoFragment = TwoFragment()
    }

    override fun initView() {
        showContenView()
    }
}