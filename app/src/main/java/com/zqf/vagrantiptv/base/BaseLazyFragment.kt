package com.zqf.vagrantiptv.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType

/**
 * 预加载页面回调的生命周期流程：
 * setUserVisibleHint() -->onAttach() --> onCreate()-->
 * onCreateView()-->onActivityCreate() --> onStart() --> onResume()
 */
abstract class BaseLazyFragment<VB : ViewBinding, P : BasePresenter<out BaseIView>> : Fragment() {

    lateinit var mPresenter: P
    lateinit var mVBind: VB
    lateinit var mContext: FragmentActivity

    // 布局是否初始化
    private var isViewCreated = false

    // 记录Fragment的可见状态
    private var currentVisibleStatus = false

    // 是否第一次加载
    private var isFirstLoad = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mContext = requireActivity()
        mPresenter = getPresenter()
        lifecycle.addObserver(mPresenter)
        val type = javaClass.genericSuperclass
        val clazz = (type as ParameterizedType).actualTypeArguments[0] as Class<VB>
        val method = clazz.getMethod(
            "inflate",
            LayoutInflater::class.java,
            ViewGroup::class.java,
            Boolean::class.java
        )
        mVBind = method.invoke(null, layoutInflater, container, false) as VB
        isViewCreated = true
        return mVBind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // isHidden 如果该Fragment对象已经被隐藏，那么它返回true
        initV()
        if (!isHidden && userVisibleHint) {
            dispatchVisible(true)
        }
    }

    override fun onResume() {
        super.onResume()
        // 跳转Activity回来后，缓存的Fragment会走onResume
        // 如果不是第一次加载就再次加载数据
        if (!isFirstLoad) {
            // isHidden = false, userVisibleHint = true, currentVisibleStatus
            // userVisibleHint && !currentVisibleStatus 不可见--> 可见
            if (!isHidden && userVisibleHint && !currentVisibleStatus) {
                dispatchVisible(true)
            }
        }
    }

    /**
     *   1.可见--> 不可见
     *   2.不可见--> 可见
     *   isVisibleToUser
     *   currentVisibleStatus 判断当前的状态
     */
    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        // 在界面初始化好后才开始分发可见状态加载数据
        // 但是函数是在生命周期之前调用的，所以第一个显示的fragment界面还没绘制之前，这个函数就已经结束了，所以分发不到事件
        if (isViewCreated) {
            if (!isVisibleToUser && currentVisibleStatus) {
                // 1.可见--> 不可见
                dispatchVisible(false)
            } else if (isVisibleToUser && !currentVisibleStatus) {
                // 2.不可见--> 可见
                dispatchVisible(true)
            }
        }

    }

    /**
     * 分发可见事件，加载数据
     */
    private fun dispatchVisible(isVisible: Boolean) {
        currentVisibleStatus = isVisible
        // 解决viewpager嵌套 子fragment会加载数据的问题
        if (isVisible && isParentVisible()) {
            return
        }

        if (isVisible) {
            if (isFirstLoad) {
                onFgFirstVisible()
                isFirstLoad = false
            }
            //onFgResume()
            dispatchChild(true)
        } else {
            onFgPause()
            dispatchChild(false)
        }

    }

    /**
     * 父Fragment 是否可见
     * return false 是分发
     * return true 是不分发 ---> 就是不可见的时候 ---> currentVisibleStatus == false
     * 所以刚好和currentVisibleStatus相反
     */
    private fun isParentVisible(): Boolean {
        if (parentFragment is BaseLazyFragment<*, *>) {
            return (parentFragment as BaseLazyFragment<*, *>).isSupportVisible()
        }
        return false
    }


    private fun isSupportVisible(): Boolean {
        return !currentVisibleStatus // 可见 true  不可见 false
    }

    override fun onStop() {
        super.onStop()
        // 表示已经跳转到其他Activity去了
        if (currentVisibleStatus) {
            currentVisibleStatus = false
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        isViewCreated = false
    }

    private fun dispatchChild(visible: Boolean) {
        val fragments = childFragmentManager.fragments //  List<Fragment>
        fragments.forEach {
            if (it is BaseLazyFragment<*, *> && !it.isHidden && it.userVisibleHint) {
                it.dispatchVisible(visible)
            }
        }
    }


    /**
     * 加载数据
     * 停止加载数据
     * 第一次加载数据
     */
    //abstract fun onFgResume()

    open fun onFgPause() {}

    open fun onFgFirstVisible() {}

    abstract fun getPresenter(): P

    abstract fun initV()
}