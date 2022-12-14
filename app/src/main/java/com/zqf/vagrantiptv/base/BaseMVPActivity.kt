package com.zqf.vagrantiptv.base

import android.app.Activity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseMVPActivity<VB : ViewBinding, P : BasePresenter<out BaseIView>> :
    AppCompatActivity() {

    lateinit var mPresenter: P
    lateinit var mVBind: VB
    lateinit var mContext: Activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = this
        mPresenter = getPresent()
        lifecycle.addObserver(mPresenter)
        if (isFullScreen()) {
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        mVBind = getViewBinding()
        val contentView = mVBind.root
        setContentView(contentView)
        initV()
    }

    abstract fun getViewBinding(): VB

    abstract fun getPresent(): P

    abstract fun initV()

    private fun isFullScreen(): Boolean {
        return false
    }

    fun showLoading() {}

    fun hideLoading() {}

}