package com.sujian.baseandroid.base.contract

/**
 *   author: sujian
 *   date: 2018/8/20
 *   desc: 契约基类
 */


class BaseContract{

    interface  IBaseView {
        fun showLoading()

        fun hideLoading()

        fun showMsg(msg:String)

        fun showEmptyView()

        fun showNotNetView()

        fun  showContenView()
    }



    interface IBasePresenter{

        fun onCreate()
        fun onResume()
        fun onDestroy()
    }

}
