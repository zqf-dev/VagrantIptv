package com.zqf.vagrantiptv.ui.fg

import com.zqf.vagrantiptv.R
import com.zqf.vagrantiptv.base.BaseFragment
import com.zqf.vagrantiptv.databinding.DiscoverFgLayoutBinding
import com.zqf.vagrantiptv.ui.adapter.DiscoverAdapter
import com.zqf.vagrantiptv.ui.contact.DiscoverFgContact
import com.zqf.vagrantiptv.ui.presenter.DiscoverFgPresenter
import com.zqf.vagrantiptv.utils.RvUtil

class DiscoverFg : BaseFragment<DiscoverFgLayoutBinding, DiscoverFgPresenter>(),
    DiscoverFgContact.ViewBase {

    private val mDiscoverAdapter by lazy {
        DiscoverAdapter(R.layout.discover_item_layout)
    }

    override fun getPresenter(): DiscoverFgPresenter {
        return DiscoverFgPresenter(this)
    }

    override fun initV() {
        mPresenter.getData()
        val list = mutableListOf<String>()
        mVBind.disRecycle.layoutManager = RvUtil.vertical(mContext)
        mVBind.disRecycle.adapter = mDiscoverAdapter
        mDiscoverAdapter.setList(list)
    }
}