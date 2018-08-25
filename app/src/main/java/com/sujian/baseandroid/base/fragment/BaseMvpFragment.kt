package com.sujian.baseandroid.base.fragment

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.View
import com.sujian.baseandroid.base.contract.BaseContract


/**
 *   author: sujian
 *   date: 2018/8/20
 *   desc: xxx
 */
abstract class BaseMvpFragment<P:BaseContract.IBasePresenter>: BaseFragment(),BaseContract.IBaseView {


    protected var mPresenter:P?=null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        initPresenter()
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mPresenter?.onCreate()
    }


    override fun onResume() {
        super.onResume()
        mPresenter?.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter?.onDestroy()
    }


    abstract fun initPresenter()
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