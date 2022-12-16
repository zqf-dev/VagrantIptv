package com.zqf.vagrantiptv.app

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.scwang.smart.refresh.footer.ClassicsFooter
import com.scwang.smart.refresh.header.ClassicsHeader
import com.scwang.smart.refresh.layout.SmartRefreshLayout
import com.scwang.smart.refresh.layout.listener.DefaultRefreshFooterCreator
import com.scwang.smart.refresh.layout.listener.DefaultRefreshHeaderCreator
import com.tencent.mmkv.MMKV
import com.zqf.vagrantiptv.BuildConfig
import com.zqf.vagrantiptv.R
import com.zqf.vagrantiptv.utils.FLog


class App : Application() {

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        initLog()
        initKKMV()
    }

    private fun initLog() {
        FLog.setDebug(BuildConfig.DEBUG)
    }

    private fun initKKMV() {
        val mMMKVPath = MMKV.initialize(this)
        FLog.e("mmkv path: >>$mMMKVPath")
    }

    private fun getContext(): Context {
        return context
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context

        init {
            SmartRefreshLayout.setDefaultRefreshHeaderCreator(DefaultRefreshHeaderCreator { context, layout ->
                //设置刷新头的背景色
                layout.setPrimaryColorsId(R.color.transparent)
                return@DefaultRefreshHeaderCreator ClassicsHeader(context)
            })
            SmartRefreshLayout.setDefaultRefreshFooterCreator(DefaultRefreshFooterCreator { context, layout ->
                //设置滑动到底部自动加载更多
                layout.setEnableAutoLoadMore(false)
                return@DefaultRefreshFooterCreator ClassicsFooter(context).setDrawableSize(20f)
            })
        }
    }
}