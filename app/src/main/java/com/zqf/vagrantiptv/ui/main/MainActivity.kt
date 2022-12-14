package com.zqf.vagrantiptv.ui.main

import android.view.KeyEvent
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.zqf.vagrantiptv.R
import com.zqf.vagrantiptv.base.BaseMVPActivity
import com.zqf.vagrantiptv.databinding.ActivityMainBinding
import com.zqf.vagrantiptv.ui.presenter.MainPresenter

/**
 * Main主页
 */
class MainActivity : BaseMVPActivity<ActivityMainBinding, MainPresenter>() {

    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun getPresent(): MainPresenter {
        return MainPresenter()
    }

    override fun initV() {
        val mBnv = mVBind.bnv
        val mNHostFg = supportFragmentManager.findFragmentById(R.id.content_main) as NavHostFragment
        val navController = mNHostFg.navController
        //Theme主题不是NoActionBar可绑定menu
        //val configuration = AppBarConfiguration.Builder(mBnv.menu).build()
        //NavigationUI.setupActionBarWithNavController(this, navController, configuration)
        NavigationUI.setupWithNavController(mBnv, navController)
        mBnv.setOnLongClickListener { true }
    }

    private var exitTime: Long = 0
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && event?.action == KeyEvent.ACTION_DOWN) {
            if (System.currentTimeMillis() - exitTime > 2000) {
                Toast.makeText(this, "再按一次退出应用", Toast.LENGTH_SHORT).show()
                exitTime = System.currentTimeMillis()
            } else {
                finish()
            }
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}