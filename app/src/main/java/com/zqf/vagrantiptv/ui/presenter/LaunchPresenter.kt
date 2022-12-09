package com.zqf.vagrantiptv.ui.presenter

import android.app.Activity
import com.zqf.vagrantiptv.base.IPresenter
import com.zqf.vagrantiptv.ui.contact.LaunchContact

/**
 * Author: zqf
 * Date: 2021/10/08
 * 启动页的presenter
 */
class LaunchPresenter : IPresenter<LaunchContact.LaunchView>,
    LaunchContact.Presenter {

    override fun attachView(view: LaunchContact.LaunchView) {

    }

    override fun detachView() {

    }

    override fun handlerDelayed(activity: Activity) {

    }
}