package com.zqf.vagrantiptv.ui.fg

import android.os.Bundle
import com.scwang.smart.refresh.layout.api.RefreshLayout
import com.scwang.smart.refresh.layout.listener.OnRefreshListener
import com.zqf.vagrantiptv.base.BaseLazyFragment
import com.zqf.vagrantiptv.databinding.OthertypefgLayoutBinding
import com.zqf.vagrantiptv.ui.contact.OtherTypeFgContact
import com.zqf.vagrantiptv.ui.presenter.OtherTypeFgPresenter

/**
 * 首页Tab分类下通用的Fragment
 */
class TabTypeFg : BaseLazyFragment<OthertypefgLayoutBinding, OtherTypeFgPresenter>(),
    OtherTypeFgContact.IView, OnRefreshListener {

    private var p: Int = -1

    companion object {
        fun getInstance(p: Int): TabTypeFg {
            val otherTypeFg = TabTypeFg()
            val bundle = Bundle()
            bundle.putInt("position", p)
            otherTypeFg.arguments = bundle
            return otherTypeFg
        }
    }

    override fun getPresenter(): OtherTypeFgPresenter {
        return OtherTypeFgPresenter(this)
    }

    override fun initV() {
        p = arguments?.getInt("position", -1)!!
        mVBind.srl.setOnRefreshListener(this)
    }

    override fun onFgFirstVisible() {
        super.onFgFirstVisible()
        mPresenter.getIPTVData(p)
    }

    override fun onRefresh(refreshLayout: RefreshLayout) {

    }
}