package com.zqf.vagrantiptv.ui.main

import com.zqf.vagrantiptv.base.BaseMVPActivity
import com.zqf.vagrantiptv.databinding.ActivityMainBinding
import com.zqf.vagrantiptv.ui.presenter.MainPresenter

/**
 * Main主页
 */
class MainActivity : BaseMVPActivity<ActivityMainBinding, MainPresenter>() {

    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun getPresent(): MainPresenter {
        return MainPresenter()
    }

    override fun initV() {

    }
}