package com.sujian.baseandroid.ui

import com.sujian.baseandroid.R
import com.sujian.baseandroid.base.activity.BaseTitleActivity
import com.sujian.baseandroid.ui.home.HomeActivity
import io.reactivex.Flowable
import org.jetbrains.anko.startActivity
import java.util.concurrent.TimeUnit

class SplashActivity : BaseTitleActivity() {
    override fun getTitleText(): String = ""
    override fun getLayoutResId(): Int = R.layout.activity_splash
    override fun isAddToolbar(): Boolean = false

    override fun initView() {
        Flowable.timer(3, TimeUnit.SECONDS)
                .compose(this.bindToLifecycle())
                .subscribe { startNextActivity() }

    }

    private fun startNextActivity() {
        startActivity<HomeActivity>()
    }


}
