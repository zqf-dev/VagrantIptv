package com.zqf.vagrantiptv.ui.launch

import com.zqf.vagrantiptv.base.BaseMVPActivity
import com.zqf.vagrantiptv.databinding.LaunchActivityBinding
import com.zqf.vagrantiptv.ui.contact.LaunchContact
import com.zqf.vagrantiptv.ui.presenter.LaunchPresenter

/**
 * 启动页
 */
class LauncherActivity : BaseMVPActivity<LaunchActivityBinding, LaunchPresenter>(),
    LaunchContact.LaunchView {

    override fun getViewBinding(): LaunchActivityBinding {
        return LaunchActivityBinding.inflate(layoutInflater)
    }

    override fun getPresent(): LaunchPresenter {
        return LaunchPresenter(this)
    }

    override fun initV() {
        mPresenter.delayed(this)
    }
}