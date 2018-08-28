package com.sujian.baseandroid.ui

import com.sujian.baseandroid.Constant
import com.sujian.baseandroid.R
import com.sujian.baseandroid.base.activity.BaseTitleActivity
import com.sujian.baseandroid.ext.loadUrl
import com.sujian.baseandroid.rx.SchedulerUtils
import com.sujian.baseandroid.ui.home.HomeActivity
import com.sujian.baseandroid.utils.SpUtils
import com.trello.rxlifecycle2.android.ActivityEvent
import io.reactivex.Flowable
import kotlinx.android.synthetic.main.activity_splash.*
import java.util.concurrent.TimeUnit

class SplashActivity : BaseTitleActivity() {
    override fun getTitleText(): String = ""
    override fun getLayoutResId(): Int = R.layout.activity_splash
    override fun isAddToolbar(): Boolean = false

    override fun initView() {


        val finish = SpUtils.getValue(Constant.AD_IMG_DOWNLOAD_FINSH, false)

        if (finish) {
            splash_iv.loadUrl(SpUtils.getValue(Constant.AD_IMG_KEY, ""))
        }


        Flowable.timer(3, TimeUnit.SECONDS)
                .compose(SchedulerUtils.io_main())
                .compose(this.bindUntilEvent(ActivityEvent.DESTROY))
                .subscribe { startNextActivity(HomeActivity::class.java) }
    }


}
