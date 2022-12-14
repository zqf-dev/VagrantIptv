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

    //懒加载过
    var isLazyLoaded: Boolean = false
    lateinit var mPresenter: P
    lateinit var mVBind: VB
    lateinit var mContext: FragmentActivity

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
        return mVBind.root
    }

    override fun onResume() {
        super.onResume()
        if (!isLazyLoaded && !isHidden) {
            isLazyLoaded = true
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        isLazyLoaded = false
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initV()
    }

    abstract fun getPresenter(): P

    abstract fun initV()
}