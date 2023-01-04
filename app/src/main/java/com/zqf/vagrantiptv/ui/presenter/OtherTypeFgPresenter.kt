package com.zqf.vagrantiptv.ui.presenter

import com.zqf.vagrantiptv.base.BasePresenter
import com.zqf.vagrantiptv.entity.TabTypeMultiEntity
import com.zqf.vagrantiptv.ui.contact.OtherTypeFgContact
import com.zqf.vagrantiptv.utils.LFog
import com.zqf.vagrantiptv.utils.FileUtils
import com.zqf.vagrantiptv.utils.IPTVDataSource
import kotlinx.coroutines.launch
import org.json.JSONObject

class OtherTypeFgPresenter(v: OtherTypeFgContact.IView) :
    BasePresenter<OtherTypeFgContact.IView>(), OtherTypeFgContact.Presenter {

    init {
        attachView(v)
    }

    override fun getIPTVData(p: Int) {
        if (p >= 0) {
            mCoroutineScope.launch {
                val data = IPTVDataSource.getData(FileUtils.typeToAssetsName(p))
                LFog.e("data:>> $data")
                val json = JSONObject(data)
                val arrays = json.optJSONArray("data")
                val res = mutableListOf<TabTypeMultiEntity>()
                for (index in 0 until arrays.length()) {
                    val obj = arrays[index] as JSONObject
                    res.add(TabTypeMultiEntity(0, obj.optString("url"), obj.optString("title")))
                }
                getView()!!.recycleData(res)
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