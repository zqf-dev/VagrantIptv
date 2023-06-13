package com.zqf.vagrantiptv.app

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import com.scwang.smart.refresh.footer.ClassicsFooter
import com.scwang.smart.refresh.header.ClassicsHeader
import com.scwang.smart.refresh.layout.SmartRefreshLayout
import com.scwang.smart.refresh.layout.listener.DefaultRefreshFooterCreator
import com.scwang.smart.refresh.layout.listener.DefaultRefreshHeaderCreator
import com.tencent.mmkv.MMKV
import com.tencent.smtt.export.external.TbsCoreSettings
import com.tencent.smtt.sdk.QbSdk
import com.zqf.vagrantiptv.BuildConfig
import com.zqf.vagrantiptv.R


class App : Application() {

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        initLog()
        initKKMV()
        initXWebView()
    }

    private fun initXWebView() {
        // 在调用TBS初始化、创建WebView之前进行如下配置
        val map = HashMap<String, Any>()
        map[TbsCoreSettings.TBS_SETTINGS_USE_SPEEDY_CLASSLOADER] = true
        map[TbsCoreSettings.TBS_SETTINGS_USE_DEXLOADER_SERVICE] = true
        QbSdk.initTbsSettings(map)
        QbSdk.initX5Environment(context, object : QbSdk(), QbSdk.PreInitCallback {
            override fun onCoreInitFinished() {
                // 内核初始化完成，可能为系统内核，也可能为系统内核
            }

            /**
             * 预初始化结束
             * 由于X5内核体积较大，需要依赖网络动态下发，所以当内核不存在的时候，默认会回调false，此时将会使用系统内核代替
             * @param isX5 是否使用X5内核
             */
            override fun onViewInitFinished(p0: Boolean) {

            }
        })
    }

    private fun initLog() {
        val formatStrategy = PrettyFormatStrategy.newBuilder()
            .methodCount(0)
            .methodOffset(3)
            .tag("VTag")
            .build()
        Logger.addLogAdapter(object : AndroidLogAdapter(formatStrategy) {
            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return BuildConfig.DEBUG
            }
        })
    }

    private fun initKKMV() {
        val mMMKVPath = MMKV.initialize(this)
        Logger.e("mmkv path: >>$mMMKVPath")
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
                layout.setEnableLoadMore(false)
                return@DefaultRefreshFooterCreator ClassicsFooter(context).setDrawableSize(20f)
            })
        }
    }
}