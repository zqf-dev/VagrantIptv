package com.zqf.vagrantiptv.ui.presenter

import com.zqf.vagrantiptv.base.BasePresenter
import com.zqf.vagrantiptv.ui.contact.OtherTypeFgContact
import com.zqf.vagrantiptv.utils.FLog
import com.zqf.vagrantiptv.utils.FileUtils
import com.zqf.vagrantiptv.utils.IPTVDataSource
import kotlinx.coroutines.launch

class OtherTypeFgPresenter(v: OtherTypeFgContact.IView) :
    BasePresenter<OtherTypeFgContact.IView>(), OtherTypeFgContact.Presenter {

    init {
        attachView(v)
    }

    override fun getIPTVData(p: Int) {
        FLog.e("t:>> $p")
        if (p >= 0) {
            mCoroutineScope.launch {
                val data = IPTVDataSource.getData(FileUtils.typeToAssetsName(p))
                FLog.e("data:>> $data")
            }
        }
    }

    fun getIPTVBanner() {
        mCoroutineScope.launch {
            val data = IPTVDataSource.getBannerData()
            getView()?.banner(data)
        }
    }
}