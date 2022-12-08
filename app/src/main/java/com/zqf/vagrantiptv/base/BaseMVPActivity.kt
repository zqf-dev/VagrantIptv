package com.zqf.vagrantiptv.base

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseMVPActivity<VB : ViewBinding, P : IPresenter<out IView>> : AppCompatActivity() {

    lateinit var mPresenter: P
    lateinit var mViewBinding: VB
    lateinit var mContext: Activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}