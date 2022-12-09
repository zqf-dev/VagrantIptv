package com.zqf.vagrantiptv.ui.contact

import android.app.Activity
import com.zqf.vagrantiptv.base.IView

interface LaunchContact {

    interface LaunchView : IView {

    }

    interface Presenter {
        fun handlerDelayed(activity: Activity)
    }
}