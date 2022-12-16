package com.zqf.vagrantiptv.ui.fg

import android.os.Bundle
import com.zqf.vagrantiptv.base.BaseLazyFragment
import com.zqf.vagrantiptv.databinding.OthertypefgLayoutBinding
import com.zqf.vagrantiptv.ui.contact.OtherTypeFgContact
import com.zqf.vagrantiptv.ui.presenter.OtherTypeFgPresenter
import com.zqf.vagrantiptv.utils.FLog
import com.zqf.vagrantiptv.utils.IPTVDataSource

/**
 * 首页Tab分类下通用的Fragment
 */
class OtherTypeFg : BaseLazyFragment<OthertypefgLayoutBinding, OtherTypeFgPresenter>(),
    OtherTypeFgContact.IView {

    companion object {
        fun getInstance(p: Int): OtherTypeFg {
            val otherTypeFg = OtherTypeFg()
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

    }

    override fun onFgResume() {
        FLog.e("p: >> " + arguments?.getInt("position", 1))
        FLog.e("src: >> " + IPTVDataSource.getData("cctv.txt"))
    }
}