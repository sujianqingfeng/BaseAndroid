package com.sujian.baseandroid.ui.custom_title

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.sujian.baseandroid.R
import com.sujian.baseandroid.base.activity.BaseTitleActivity

class CustomTitleActivity : BaseTitleActivity() {

    override fun getTitleText(): String = "自定义Title"
    override fun getLayoutResId(): Int = R.layout.activity_custom_title

    override fun initView() {
        mToolbar?.setRightVisiable(false)
    }




}
