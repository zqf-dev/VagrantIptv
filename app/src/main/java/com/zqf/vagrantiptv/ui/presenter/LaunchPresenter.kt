package com.zqf.vagrantiptv.ui.presenter

import android.app.Activity
import android.os.Handler
import android.os.Looper
import com.zqf.vagrantiptv.base.BasePresenter
import com.zqf.vagrantiptv.constant.Constant
import com.zqf.vagrantiptv.ui.contact.LaunchContact
import com.zqf.vagrantiptv.ui.main.MainActivity
import com.zqf.vagrantiptv.utils.ZRouter

/**
 * Author: zqf
 * Date: 2021/10/08
 * 启动页的presenter
 */
class LaunchPresenter(v: LaunchContact.LaunchViewBase) : BasePresenter<LaunchContact.LaunchViewBase>(),
    LaunchContact.Presenter {
    private var handler: Handler? = Handler(Looper.getMainLooper())

    init {
        attachView(v)
    }

    override fun detachView() {
        super.detachView()
        handler?.removeCallbacksAndMessages(null)
        handler = null
    }

    override fun delayed(mAct: Activity) {
        handler?.postDelayed(run {
            {
                ZRouter.goActivity(mAct, MainActivity().javaClass)
                mAct.finish()
            }
        }, Constant.delayTime)
    }
}
