package com.simple.base.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import com.simple.base.BaseApplication;
import com.simple.base.R;


public class CacheUtils {

    @SuppressLint("StaticFieldLeak")
    private static Context context = BaseApplication.currentApplication();

    private static SharedPreferences SP = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE);

    public static void save(String key, String value) {
        SP.edit().putString(key, value).apply();
    }

    public static String get(String key) {
        return SP.getString(key, null);
    }
}
