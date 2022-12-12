package com.zqf.vagrantiptv.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class ZRouter {

    /**
     * activity跳转不带参数
     *
     * @param context 上下文
     * @param cls     目标
     */
    public static void goActivity(Context context, Class<? extends Activity> cls) {
        startActivity(context, cls, null, -1, -1);
    }

    /**
     * activity跳转带参数
     *
     * @param context 上下文
     * @param cls     目标
     * @param bundle  参数
     */
    public static void goActivity(Context context, Class<? extends Activity> cls, Bundle bundle) {
        startActivity(context, cls, bundle, -1, -1);
    }

    /**
     * activity跳转回调不带参数
     *
     * @param context     上下文
     * @param cls         目标
     * @param requestCode 请求码
     */
    public static void goActivityForResult(Context context, Class<? extends Activity> cls, int requestCode) {
        startActivity(context, cls, null, requestCode, -1);
    }

    /**
     * activity跳转回调带参数
     *
     * @param context     上下文
     * @param cls         目标
     * @param bundle      参数
     * @param requestCode 请求码
     */
    public static void goActivityForResult(Context context, Class<? extends Activity> cls, Bundle bundle, int requestCode) {
        startActivity(context, cls, bundle, requestCode, -1);
    }

    /**
     * activity回调
     *
     * @param context    上下文
     * @param bundle     参数
     * @param resultCode 结果码
     */
    public static void comeActivitySetResult(Context context, Bundle bundle, int resultCode) {
        startActivity(context, null, bundle, -1, resultCode);
    }

    private static void startActivity(Context context, Class<? extends Activity> cls, Bundle bundle, int requestCode, int resultCode) {
        Intent intent;
        if (null != cls) {
            intent = new Intent(context, cls);
        } else {
            intent = new Intent();
        }
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        if (-1 != resultCode) {
            ((Activity) context).setResult(resultCode, intent);
        } else {
            if (-1 != requestCode) {
                ((Activity) context).startActivityForResult(intent, requestCode);
            } else {
                context.startActivity(intent);
            }
        }
    }
}
