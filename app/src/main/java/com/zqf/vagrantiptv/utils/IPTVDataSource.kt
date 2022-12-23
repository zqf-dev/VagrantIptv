package com.zqf.vagrantiptv.utils

import android.text.TextUtils
import com.zqf.vagrantiptv.R
import com.zqf.vagrantiptv.app.App
import com.zqf.vagrantiptv.entity.BannerEntity
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader

class IPTVDataSource {

    companion object {
        fun getData(fileName: String): String {
            try {
                if (TextUtils.isEmpty(fileName)) {
                    return ""
                }
                val json = JSONObject()
                val array = JSONArray()
                json.put("code", 200)
                json.put("msg", "操作成功")
                json.put("data", array)
                val iStream = App.context.assets.open(fileName)
                val isReader = InputStreamReader(iStream)
                BufferedReader(isReader).use {
                    var line: String
                    while (true) {
                        line = it.readLine() ?: break
                        dataHandle(line, array)
                    }
                }
                iStream.close()
                isReader.close()
                return json.toString()
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return ""
        }

        private var el: String = ""
        private fun dataHandle(line: String, array: JSONArray) {
            if (line.contains("#EXTINF:-1")) {
                el = line
            }
            if (line.contains("http") || line.contains("https")) {
                val json = JSONObject()
                json.put("iptvName", el.split(",")[1])
                json.put("iptvUrl", line)
                array.put(json)
                el = ""
            }
        }

        /**
         * banner数据
         */
        fun getBannerData(): MutableList<BannerEntity> {
            val imgList = mutableListOf<BannerEntity>()
            imgList.add(BannerEntity(R.mipmap.banner1))
            imgList.add(BannerEntity(R.mipmap.banner2))
            imgList.add(BannerEntity(R.mipmap.banner3))
            imgList.add(BannerEntity(R.mipmap.banner4))
            imgList.add(BannerEntity(R.mipmap.banner5))
            imgList.add(BannerEntity(R.mipmap.banner6))
            imgList.add(BannerEntity(R.mipmap.banner7))
            imgList.add(BannerEntity(R.mipmap.banner8))
            return imgList
        }
    }
}