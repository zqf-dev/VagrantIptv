package com.zqf.vagrantiptv.ui.fg

import com.zqf.vagrantiptv.base.BaseFragment
import com.zqf.vagrantiptv.databinding.HomeFgLayoutBinding
import com.zqf.vagrantiptv.ui.adapter.HomeVpAdapter
import com.zqf.vagrantiptv.ui.contact.HomeFgContact
import com.zqf.vagrantiptv.ui.presenter.HomeFgPresenter

class HomeFg : BaseFragment<HomeFgLayoutBinding, HomeFgPresenter>(), HomeFgContact.IView {

    override fun getPresenter(): HomeFgPresenter {
        return HomeFgPresenter(this)
    }

    override fun initV() {
        //使用ViewPage2
        //mPresenter.initCnIndicatorVp2(mVBind.indicator, mVBind.vp)
        //mVBind.vp.adapter = HomeVp2Adapter(mContext, mPresenter.titleList)
        //指定跳转先显示哪个View
        //mVBind.vp.currentItem = 1
        //使用ViewPage
        mPresenter.initCnIndicatorVp(mVBind.indicator, mVBind.vp)
        mVBind.vp.adapter = HomeVpAdapter(childFragmentManager, mPresenter.titleList)
        mVBind.vp.offscreenPageLimit = mPresenter.titleList.size
        if (mVBind.vp.currentItem == 0) tabSelect(0)
    }

    override fun tabSelect(p: Int) {

    }
}