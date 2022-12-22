package com.zqf.vagrantiptv.utils;

public class FileUtils {

    /**
     * 将位置转化为Assets文件的Name
     *
     * @param p position
     * @return name
     */
    public static String typeToAssetsName(int p) {
        switch (p) {
            case 0:
                return "ss.txt";
            case 1:
                return "cctv.txt";
            case 2:
                return "ws.txt";
            case 3:
                return "zy.txt";
            case 4:
                return "jc.txt";
            case 5:
                return "foods.txt";
            case 6:
                return "dm.txt";
            case 7:
                return "travel.txt";
            case 8:
                return "sports.txt";
            case 9:
                return "music.txt";
        }
        return "";
    }

}
