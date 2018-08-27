package com.sujian.baseandroid.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sujian.baseandroid.base.contract.BaseContract
import com.sujian.baseandroid.widgets.StateView

/**
 *   author: sujian
 *   date: 2018/8/27
 *   desc: xxx
 */
abstract class BaseMvpStateFragment<P: BaseContract.IBasePresenter> :BaseMvpFragment<P>() {

    var mStateView:StateView?=null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        mView = StateView(getLayoutResId(),this.context!!)
        mStateView = mView as StateView

//        mView = inflater.inflate(getLayoutResId(),container,false)
        return mView
    }

    override fun showEmptyView() {
        mStateView?.showEmptyView()
    }


    override fun showLoading() {
        mStateView?.showLadingView()
    }

    override fun showContenView() {
        mStateView?.showContentView()
    }


}