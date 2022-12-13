package com.zqf.vagrantiptv.ui.fg

import com.zqf.vagrantiptv.base.BaseFragment
import com.zqf.vagrantiptv.databinding.MeFgLayoutBinding
import com.zqf.vagrantiptv.ui.contact.MeFgContact
import com.zqf.vagrantiptv.ui.presenter.MeFgPresenter

class MeFg : BaseFragment<MeFgLayoutBinding, MeFgPresenter>(),
    MeFgContact.View {
    override fun getPresenter(): MeFgPresenter {
        return MeFgPresenter(this)
    }
}