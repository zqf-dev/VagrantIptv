package com.zqf.vagrantiptv.ui.fg

import android.annotation.SuppressLint
import com.zqf.kotlinwanandroid.util.RvUtil
import com.zqf.vagrantiptv.R
import com.zqf.vagrantiptv.base.BaseFragment
import com.zqf.vagrantiptv.databinding.MeFgLayoutBinding
import com.zqf.vagrantiptv.entity.MeRecycleEntity
import com.zqf.vagrantiptv.ui.adapter.MeAdapter
import com.zqf.vagrantiptv.ui.contact.MeFgContact
import com.zqf.vagrantiptv.ui.presenter.MeFgPresenter

class MeFg : BaseFragment<MeFgLayoutBinding, MeFgPresenter>(),
    MeFgContact.ViewBase {

    private val meAdapter by lazy {
        MeAdapter(R.layout.me_recycle_item)
    }

    override fun getPresenter(): MeFgPresenter {
        return MeFgPresenter(this)
    }

    override fun initV() {
        mPresenter.getMeData()
        mVBind.meRecycle.layoutManager = RvUtil.vertical(mContext)
        mVBind.meRecycle.adapter = meAdapter
    }

    override fun meData(list: MutableList<MeRecycleEntity>) {
        meAdapter.setList(list)
    }
}