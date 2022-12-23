package com.zqf.vagrantiptv.utils

import com.zqf.vagrantiptv.R

class ColorsUtil {

    companion object {

        fun tabSelectColor(position: Int): Int {
            return when (position) {
                0 -> R.color.purple_500
                1 -> R.color.red
                else -> {
                    R.color.purple_500
                }
            }
        }
    }
}