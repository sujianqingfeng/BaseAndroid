package com.sujian.baseandroid.ui.home

import com.orhanobut.logger.Logger
import com.sujian.baseandroid.base.presenter.BasePresenter
import com.sujian.baseandroid.data.DataManger
import com.sujian.baseandroid.data.bean.HomeBean
import com.sujian.baseandroid.rx.BaseSubscriber
import com.sujian.baseandroid.rx.SchedulerUtils


/**
 *   author: sujian
 *   date: 2018/8/22
 *   desc: xxx
 */
class HomePresenter(private val mView:HomeContract.View) : BasePresenter(), HomeContract.Presenter {


    override fun onCreate() {

        addSubscribe( DataManger.getHome()
                .compose(SchedulerUtils.io_main())
                .subscribeWith(object :BaseSubscriber<HomeBean>(){
                    override fun onNext(t: HomeBean) {
                        mView.showText(t)
                    }
                }))

    }
}