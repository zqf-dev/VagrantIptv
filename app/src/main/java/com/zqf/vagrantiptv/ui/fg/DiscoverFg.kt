package com.zqf.vagrantiptv.ui.fg

import android.webkit.WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
import com.zqf.vagrantiptv.base.BaseFragment
import com.zqf.vagrantiptv.databinding.DiscoverFgLayoutBinding
import com.zqf.vagrantiptv.ui.contact.DiscoverFgContact
import com.zqf.vagrantiptv.ui.presenter.DiscoverFgPresenter

class DiscoverFg : BaseFragment<DiscoverFgLayoutBinding, DiscoverFgPresenter>(),
    DiscoverFgContact.ViewBase {

    override fun getPresenter(): DiscoverFgPresenter {
        return DiscoverFgPresenter(this)
    }

    override fun initV() {
        //处理http 和 https 图片混合的问题
        mVBind.disWebview.settings.mixedContentMode = MIXED_CONTENT_ALWAYS_ALLOW
        mVBind.disWebview.loadUrl("https://tv.cctv.com/m/")
    }
}