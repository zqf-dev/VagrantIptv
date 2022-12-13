package com.zqf.vagrantiptv.ui.fg

import com.zqf.vagrantiptv.base.BaseFragment
import com.zqf.vagrantiptv.databinding.HomeFgLayoutBinding
import com.zqf.vagrantiptv.ui.contact.HomeFgContact
import com.zqf.vagrantiptv.ui.presenter.HomeFgPresenter

class HomeFg : BaseFragment<HomeFgLayoutBinding, HomeFgPresenter>(), HomeFgContact.HomeFgView {

    override fun getPresenter(): HomeFgPresenter {
        return HomeFgPresenter(this)
    }
}