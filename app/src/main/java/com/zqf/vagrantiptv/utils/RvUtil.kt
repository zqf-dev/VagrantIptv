package com.zqf.kotlinwanandroid.util

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Author: zqf
 * Date: 2021/11/08
 */
class RvUtil {

    companion object {

        fun vertical(context: Context): RecyclerView.LayoutManager {
            return LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }

        fun horizontal(context: Context): RecyclerView.LayoutManager {
            return LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
    }
}