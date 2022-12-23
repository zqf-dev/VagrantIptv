package com.zqf.vagrantiptv.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.youth.banner.adapter.BannerAdapter
import com.zqf.vagrantiptv.R
import com.zqf.vagrantiptv.entity.BannerEntity
import com.zqf.vagrantiptv.utils.glideLocalLoad

/**
 * Author: zqf
 * Date: 2021/11/08
 */
class HomeBannerAdapter(data: List<BannerEntity>) :
    BannerAdapter<BannerEntity, HomeBannerAdapter.ImgViewHolder>(data) {

    override fun onCreateHolder(parent: ViewGroup, viewType: Int): ImgViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.home_banner_iamge, parent, false)
        return ImgViewHolder(view)
    }

    override fun onBindView(holder: ImgViewHolder, data: BannerEntity, position: Int, size: Int) {
        glideLocalLoad(data.img, holder.image)
    }

    class ImgViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val image: AppCompatImageView = view.findViewById(R.id.home_banner_image)
    }
}