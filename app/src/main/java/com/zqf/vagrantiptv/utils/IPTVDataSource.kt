package com.zqf.vagrantiptv.utils

import android.text.TextUtils
import com.zqf.vagrantiptv.app.App
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
            }catch (e: Exception) {
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
    }
}