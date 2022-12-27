package com.zqf.vagrantiptv.ui.fg

import android.annotation.SuppressLint
import android.os.Bundle
import com.scwang.smart.refresh.layout.api.RefreshLayout
import com.scwang.smart.refresh.layout.listener.OnRefreshListener
import com.shuyu.gsyvideoplayer.GSYVideoManager
import com.youth.banner.Banner
import com.youth.banner.indicator.CircleIndicator
import com.zqf.kotlinwanandroid.util.RvUtil
import com.zqf.vagrantiptv.R
import com.zqf.vagrantiptv.base.BaseLazyFragment
import com.zqf.vagrantiptv.constant.Constant
import com.zqf.vagrantiptv.databinding.OthertypefgLayoutBinding
import com.zqf.vagrantiptv.entity.BannerEntity
import com.zqf.vagrantiptv.entity.TabTypeMultiEntity
import com.zqf.vagrantiptv.ui.adapter.HomeBannerAdapter
import com.zqf.vagrantiptv.ui.adapter.TabTypeRecycleAdapter
import com.zqf.vagrantiptv.ui.contact.OtherTypeFgContact
import com.zqf.vagrantiptv.ui.presenter.OtherTypeFgPresenter
import com.zqf.vagrantiptv.utils.FLog

/**
 * 首页Tab分类下通用的Fragment
 */
class TabTypeFg : BaseLazyFragment<OthertypefgLayoutBinding, OtherTypeFgPresenter>(),
    OtherTypeFgContact.IView, OnRefreshListener {

    private var p = 0
    private lateinit var banner: Banner<BannerEntity, HomeBannerAdapter>
    private val mTabTypeRecycleAdapter by lazy {
        TabTypeRecycleAdapter()
    }

    companion object {
        fun getInstance(p: Int): TabTypeFg {
            val otherTypeFg = TabTypeFg()
            val bundle = Bundle()
            bundle.putInt(Constant.key, p)
            otherTypeFg.arguments = bundle
            return otherTypeFg
        }
    }

    override fun getPresenter(): OtherTypeFgPresenter {
        return OtherTypeFgPresenter(this)
    }

    @SuppressLint("InflateParams")
    override fun initV() {
        p = arguments!!.getInt(Constant.key)
        val headView = layoutInflater.inflate(R.layout.banner_head_layout, null, false)
        banner = headView.findViewById(R.id.banner)
        banner.setLoopTime(5000).addBannerLifecycleObserver(this)
        banner.indicator = CircleIndicator(mContext)
        mVBind.recycle.layoutManager = RvUtil.vertical(mContext)
        mVBind.recycle.adapter = mTabTypeRecycleAdapter
        mTabTypeRecycleAdapter.addHeaderView(headView)
        mVBind.srl.setOnRefreshListener(this)
    }

    override fun onFgFirstVisible() {
        super.onFgFirstVisible()
        mPresenter.getIPTVData(p)
        mPresenter.getIPTVBanner()
    }

    override fun recycleData(data: MutableList<TabTypeMultiEntity>) {
        FLog.e("list: >> $data")
        mTabTypeRecycleAdapter.setList(data)
    }

    override fun banner(dataBanner: MutableList<BannerEntity>) {
        banner.setAdapter(HomeBannerAdapter(dataBanner))
        banner.setOnBannerListener { data, position ->
            val entity = data as BannerEntity
        }
    }

    override fun onRefresh(refreshLayout: RefreshLayout) {
        mVBind.srl.finishRefresh()
    }

    override fun onResume() {
        super.onResume()
        GSYVideoManager.onResume()
    }

    override fun onPause() {
        super.onPause()
        GSYVideoManager.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        GSYVideoManager.releaseAllVideos()
    }
}