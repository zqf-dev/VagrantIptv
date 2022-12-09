package com.zqf.vagrantiptv.base

import android.app.Activity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.viewbinding.ViewBinding

abstract class BaseMVPActivity<VB : ViewDataBinding, P : BasePresenter<out IView>> : AppCompatActivity() {

    lateinit var mPresenter: P
    lateinit var mViewBinding: VB
    lateinit var mContext: Activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = this
        mPresenter = getPresent()
        if (isFullScreen()) {
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        if (getLayout() > 0) {
            mViewBinding = getViewBinding()
            setContentView(mViewBinding.root)
            initV()
        }
    }

    abstract fun initV()

    abstract fun getViewBinding(): VB

    abstract fun getLayout(): Int

    private fun isFullScreen(): Boolean {
        return false
    }

    abstract fun getPresent(): P

}