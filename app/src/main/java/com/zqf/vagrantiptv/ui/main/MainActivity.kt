package com.zqf.vagrantiptv.ui.main

import android.os.Bundle
import android.view.KeyEvent
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.zqf.vagrantiptv.R
import com.zqf.vagrantiptv.base.BaseMVPActivity
import com.zqf.vagrantiptv.databinding.ActivityMainBinding
import com.zqf.vagrantiptv.ui.fg.DiscoverFg
import com.zqf.vagrantiptv.ui.fg.HomeFg
import com.zqf.vagrantiptv.ui.fg.MeFg
import com.zqf.vagrantiptv.ui.presenter.MainPresenter
import com.zqf.vagrantiptv.utils.StatusBarUtils

/**
 * Main主页
 */
class MainActivity : BaseMVPActivity<ActivityMainBinding, MainPresenter>() {

    private val FRAGMENT_HOME = 0x01
    private val FRAGMENT_DISCOVER = 0x02
    private val FRAGMENT_ME = 0x03
    private var mIndex = FRAGMENT_HOME
    private var mHomeFg: HomeFg? = null
    private var mDiscoverFg: DiscoverFg? = null
    private var mMeFg: MeFg? = null
    private val BOTTOM_INDEX: String = "bottom_index"

    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun getPresent(): MainPresenter {
        return MainPresenter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
            mIndex = savedInstanceState.getInt(BOTTOM_INDEX)
        }
        super.onCreate(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(BOTTOM_INDEX, mIndex)
    }

    override fun initV() {
        showFragment(mIndex)
        mVBind.bnv.setOnItemSelectedListener {
            return@setOnItemSelectedListener when (it.itemId) {
                R.id.home_fg -> {
                    tabStatusColor(it.itemId)
                    showFragment(FRAGMENT_HOME)
                    true
                }
                R.id.discover_fg -> {
                    showFragment(FRAGMENT_DISCOVER)
                    true
                }
                R.id.me_fg -> {
                    showFragment(FRAGMENT_ME)
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    /**
     * 状态栏颜色改变
     */
    private fun tabStatusColor(itemId: Int) {
        if (itemId != R.id.home_fg) {
            StatusBarUtils.reset(this)
        }
    }

    private fun showFragment(index: Int) {
        val transaction = supportFragmentManager.beginTransaction()
        hideFragments(transaction)
        mIndex = index
        when (index) {
            FRAGMENT_HOME
            -> {
                if (mHomeFg == null) {
                    mHomeFg = HomeFg()
                    transaction.add(R.id.c_main, mHomeFg!!, "home")
                } else {
                    transaction.show(mHomeFg!!)
                }
            }
            FRAGMENT_DISCOVER
            -> {
                if (mDiscoverFg == null) {
                    mDiscoverFg = DiscoverFg()
                    transaction.add(R.id.c_main, mDiscoverFg!!, "discover")
                } else {
                    transaction.show(mDiscoverFg!!)
                }
            }
            FRAGMENT_ME
            -> {
                if (mMeFg == null) {
                    mMeFg = MeFg()
                    transaction.add(R.id.c_main, mMeFg!!, "me")
                } else {
                    transaction.show(mMeFg!!)
                }
            }
        }
        transaction.commit()
    }

    private fun hideFragments(transaction: FragmentTransaction) {
        mHomeFg?.let { transaction.hide(it) }
        mDiscoverFg?.let { transaction.hide(it) }
        mMeFg?.let { transaction.hide(it) }
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

    override fun onDestroy() {
        super.onDestroy()
        mHomeFg = null
        mDiscoverFg = null
        mMeFg = null
    }
}