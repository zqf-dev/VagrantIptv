package com.zqf.vagrantiptv.utils

import android.app.Activity
import com.gyf.immersionbar.ImmersionBar

class StatusBarUtils {

    companion object {
        fun reset(activity: Activity) {
            ImmersionBar.with(activity).reset().init()
        }
    }
}