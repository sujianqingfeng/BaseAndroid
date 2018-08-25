package com.sujian.baseandroid.base.activity

import android.os.Bundle
import com.sujian.baseandroid.base.contract.BaseContract
import com.sujian.baseandroid.base.presenter.BasePresenter


/**
 *   author: sujian
 *   date: 2018/8/22
 *   desc: xxx
 */
abstract class BaseMvpTitleActivity<P:BaseContract.IBasePresenter> : BaseTitleActivity() {

    protected var mPresenter:P ? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = initPresenter()

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


    abstract fun initPresenter():P

}