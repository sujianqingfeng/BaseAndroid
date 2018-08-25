package com.sujian.baseandroid.ui.home

import com.sujian.baseandroid.base.contract.BaseContract
import com.sujian.baseandroid.data.bean.HomeBean


/**
 *   author: sujian
 *   date: 2018/8/22
 *   desc: xxx
 */
class HomeContract {


    interface View :BaseContract.IBaseView{
        fun showText(bean:HomeBean)
    }

    interface Presenter:BaseContract.IBasePresenter{

    }

}