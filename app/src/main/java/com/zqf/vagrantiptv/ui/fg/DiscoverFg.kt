package com.zqf.vagrantiptv.ui.fg

import com.zqf.vagrantiptv.base.BaseFragment
import com.zqf.vagrantiptv.databinding.DiscoverFgLayoutBinding
import com.zqf.vagrantiptv.ui.contact.DiscoverFgContact
import com.zqf.vagrantiptv.ui.presenter.DiscoverFgPresenter

class DiscoverFg : BaseFragment<DiscoverFgLayoutBinding, DiscoverFgPresenter>(),
    DiscoverFgContact.View {
    override fun getPresenter(): DiscoverFgPresenter {
        return DiscoverFgPresenter(this)
    }
}