package com.zqf.vagrantiptv.ui.main

import androidx.navigation.NavGraph
import androidx.navigation.NavGraphNavigator
import androidx.navigation.NavigatorProvider
import androidx.navigation.fragment.NavHostFragment
import com.zqf.vagrantiptv.R
import com.zqf.vagrantiptv.base.BaseMVPActivity
import com.zqf.vagrantiptv.databinding.ActivityMainTestBinding
import com.zqf.vagrantiptv.ui.fg.DiscoverFg
import com.zqf.vagrantiptv.ui.fg.HomeFg
import com.zqf.vagrantiptv.ui.fg.MeFg
import com.zqf.vagrantiptv.ui.presenter.MainPresenter
import com.zqf.vagrantiptv.widget.FixFragmentNavigator

class TestMainActivity : BaseMVPActivity<ActivityMainTestBinding, MainPresenter>() {
    override fun getViewBinding(): ActivityMainTestBinding {
        return ActivityMainTestBinding.inflate(layoutInflater)
    }

    override fun getPresent(): MainPresenter {
        return MainPresenter()
    }

    override fun initV() {
        val mBnv = mVBind.testBnv
        //TODO 官网Navigation方法（2行代码可搞定）
        //Theme主题不是NoActionBar可绑定menu
        //val mCMain = mVBind.cMain
        //val configuration = AppBarConfiguration.Builder(mBnv.menu).build()
        //val mNHostFg = supportFragmentManager.findFragmentById(R.id.c_main) as NavHostFragment
        //NavigationUI.setupActionBarWithNavController(this, navController, configuration)
        //NavigationUI.setupWithNavController(mBnv, navController)
        //TODO 自定义Navigation方法（解决Fragment重复加载）
        val mCMain = supportFragmentManager.findFragmentById(R.id.test_c_main)
        if (mCMain != null) {
            val navController = NavHostFragment.findNavController(mCMain)
            //创建自定义的Fragment导航器
            val fgNavigator = FixFragmentNavigator(mContext, mCMain.childFragmentManager, mCMain.id)
            //获取导航器提供者
            val provider = navController.navigatorProvider
            //把自定义的Fragment导航器添加进去
            provider.addNavigator(fgNavigator)
            //手动创建导航图
            val navGraph: NavGraph = initNavGraph(provider, fgNavigator)
            //设置导航图
            navController.graph = navGraph
            //底部导航设置点击事件
            mBnv.setOnItemSelectedListener {
                navController.navigate(it.itemId)
                return@setOnItemSelectedListener true
            }
        }
        mBnv.setOnLongClickListener { true }
    }

    private fun initNavGraph(
        provider: NavigatorProvider,
        fgNavigator: FixFragmentNavigator
    ): NavGraph {
        val navGraph = NavGraph(NavGraphNavigator(provider))
        val mHomeFgCD = fgNavigator.createDestination()
        mHomeFgCD.id = R.id.home_fg
        mHomeFgCD.setClassName(HomeFg::class.java.canonicalName!!)
        navGraph.addDestination(mHomeFgCD)
        val mDisCD = fgNavigator.createDestination()
        mDisCD.id = R.id.discover_fg
        mDisCD.setClassName(DiscoverFg::class.java.canonicalName!!)
        navGraph.addDestination(mDisCD)
        val mMeCD = fgNavigator.createDestination()
        mMeCD.id = R.id.me_fg
        mMeCD.setClassName(MeFg::class.java.canonicalName!!)
        navGraph.addDestination(mMeCD)
        navGraph.setStartDestination(R.id.home_fg)
        return navGraph
    }
}