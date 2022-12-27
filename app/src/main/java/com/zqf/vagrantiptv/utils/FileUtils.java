package com.zqf.vagrantiptv.utils;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.provider.MediaStore;

import java.util.Hashtable;

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

    public static Bitmap createVideoThumbnail(String filePath, int kind) {
        Bitmap bitmap = null;
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        try {
            if (filePath.startsWith("http://")
                    || filePath.startsWith("https://")
                    || filePath.startsWith("widevine://")) {
                retriever.setDataSource(filePath, new Hashtable<>());
            } else {
                retriever.setDataSource(filePath);
            }
            bitmap = retriever.getFrameAtTime(10, MediaMetadataRetriever.OPTION_CLOSEST_SYNC);
        } catch (RuntimeException ex) {
            // Assume this is a corrupt video file
            ex.printStackTrace();
        }// Assume this is a corrupt video file.
        finally {
            try {
                retriever.release();
            } catch (RuntimeException ex) {
                // Ignore failures while cleaning up.
                ex.printStackTrace();
            }
        }

        if (bitmap == null) {
            return null;
        }

        if (kind == MediaStore.Images.Thumbnails.MINI_KIND) {//压缩图片 开始处
            // Scale down the bitmap if it's too large.
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int max = Math.max(width, height);
            if (max > 512) {
                float scale = 512f / max;
                int w = Math.round(scale * width);
                int h = Math.round(scale * height);
                bitmap = Bitmap.createScaledBitmap(bitmap, w, h, true);
            }//压缩图片 结束处
        } else if (kind == MediaStore.Images.Thumbnails.MICRO_KIND) {
            bitmap = ThumbnailUtils.extractThumbnail(bitmap, 96, 96, ThumbnailUtils.OPTIONS_RECYCLE_INPUT);
        }
        return bitmap;
    }
}
