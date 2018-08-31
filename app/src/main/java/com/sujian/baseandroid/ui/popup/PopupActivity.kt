package com.sujian.baseandroid.ui.popup

import android.graphics.Color
import android.view.View
import com.orhanobut.logger.Logger
import com.sujian.baseandroid.R
import com.sujian.baseandroid.base.activity.BaseTitleActivity
import com.sujian.baseandroid.widgets.EasyPopup.EasyPopup
import com.sujian.baseandroid.widgets.EasyPopup.XGravity
import com.sujian.baseandroid.widgets.EasyPopup.YGravity
import org.jetbrains.anko.dip

class PopupActivity : BaseTitleActivity() {
    override fun getLayoutResId(): Int = R.layout.activity_popup
    override fun getTitleText(): String = "popupwindows"

    lateinit var mQQPop:EasyPopup

    override fun initView() {

        mQQPop = EasyPopup.create()
                .setContext(this)
                .setContentView(R.layout.layout_right_pop)
                .setAnimationStyle(R.style.RightTop2PopAnim)
                .setOnViewListener { view, basePopup ->
                    //                        val arrowView = view.findViewById(R.id.v_arrow)
                    //                        arrowView.setBackground(TriangleDrawable(TriangleDrawable.TOP, Color.parseColor("#88FF88")))
                }
                .setFocusAndOutsideEnable(true)
                //                .setBackgroundDimEnable(true)
                //                .setDimValue(0.5f)
                //                .setDimColor(Color.RED)
                //                .setDimView(mTitleBar)
                .apply()

    }

    override fun onRightClick(view:View) {
        val offsetX = dip(20) - view.width / 2
        val offsetY = (mToolbar?.height!! - view.height) / 6


        Logger.e(offsetX.toString())
        Logger.e(offsetY.toString())
        Logger.e(mToolbar?.height!!.toString())
        Logger.e(view.width.toString())
        Logger.e(view.height.toString())

        mQQPop.showAtAnchorView(view, YGravity.BELOW, XGravity.ALIGN_RIGHT, offsetX, offsetY)
    }


}
