package com.zqf.vagrantiptv.ui.fg

import android.os.Bundle
import com.zqf.vagrantiptv.base.BaseFragment
import com.zqf.vagrantiptv.databinding.OthertypefgLayoutBinding
import com.zqf.vagrantiptv.ui.contact.OtherTypeFgContact
import com.zqf.vagrantiptv.ui.presenter.OtherTypeFgPresenter
import com.zqf.vagrantiptv.utils.FLog

/**
 * 首页Tab分类下通用的Fragment
 */
class OtherTypeFg : BaseFragment<OthertypefgLayoutBinding, OtherTypeFgPresenter>(),
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
        FLog.e("p: >> " + arguments?.getInt("position", 1))
    }
}