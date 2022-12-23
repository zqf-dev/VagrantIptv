package com.zqf.vagrantiptv.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.zqf.vagrantiptv.R

/**
 * 加载本地图片
 */
fun <T> T.glideLocalLoad(src: Int, imageView: ImageView) {
    Glide.with(imageView.context)
        .load(src)
        .error(R.drawable.home)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(imageView)
}

/**
 * 加载图片
 */
fun <T> T.glideLoad(url: String, imageView: ImageView) {
    Glide.with(imageView.context)
        .load(url)
        .error(R.drawable.home)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(imageView)
}

/**
 * 清除缓存的图片，视图没有使用 setTag 时有效
 */
fun <T> T.glideClear(imageView: ImageView) {
    Glide.with(imageView.context).clear(imageView)
}
