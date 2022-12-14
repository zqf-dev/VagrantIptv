package com.zqf.vagrantiptv.ui.contact

import android.app.Activity
import com.zqf.vagrantiptv.base.BaseIView

interface LaunchContact {

    interface LaunchViewBase : BaseIView {

    }

    interface Presenter {
        fun delayed(mAct: Activity)
    }
}