package com.zqf.vagrantiptv.ui.fg

import android.os.Bundle
import com.scwang.smart.refresh.layout.api.RefreshLayout
import com.scwang.smart.refresh.layout.listener.OnRefreshListener
import com.youth.banner.indicator.CircleIndicator
import com.zqf.vagrantiptv.base.BaseLazyFragment
import com.zqf.vagrantiptv.databinding.OthertypefgLayoutBinding
import com.zqf.vagrantiptv.entity.BannerEntity
import com.zqf.vagrantiptv.ui.adapter.HomeBannerAdapter
import com.zqf.vagrantiptv.ui.contact.OtherTypeFgContact
import com.zqf.vagrantiptv.ui.presenter.OtherTypeFgPresenter
import com.zqf.vagrantiptv.utils.FLog

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
        mVBind.banner.setLoopTime(5000).setBannerRound(10f)
        mVBind.banner.indicator = CircleIndicator(mContext)
    }

    override fun onFgFirstVisible() {
        super.onFgFirstVisible()
        mPresenter.getIPTVData(p)
        mPresenter.getIPTVBanner()
    }

    override fun banner(dataBanner: MutableList<BannerEntity>) {
        mVBind.banner.setAdapter(HomeBannerAdapter(dataBanner))
        mVBind.banner.setOnBannerListener { data, _ ->
            FLog.e("Banner data: >> $data")
        }
    }

    override fun onRefresh(refreshLayout: RefreshLayout) {

    }
}