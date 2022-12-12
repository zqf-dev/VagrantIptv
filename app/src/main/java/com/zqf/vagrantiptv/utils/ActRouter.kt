package com.zqf.vagrantiptv.utils

import android.app.Activity
import android.content.Intent


/**
 * Author: zqf
 * Date: 2021/10/09
 */
class ActRouter {

    companion object {
        //普通跳转至activity
        fun ofAct(activity: Activity?, cls: Class<Any>) {
            activity?.startActivity(Intent(activity, cls))
        }
    }
}