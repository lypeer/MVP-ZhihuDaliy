package com.lypeer.zhihudaily.utils;

import android.app.Application;
import android.view.View;
import android.widget.Toast;

import com.lypeer.zhihudaily.App;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

/**
 * Put some static functions that can be use everywhere
 * <p>
 * Created by lypeer on 2017/2/5.
 */

public class BaseUtil {

    public static String checkNotNull(String origin) {
        return checkNotNull(origin, "");
    }

    /**
     * To avoid null object .
     * If object is null , the function will return a default value
     *
     * @param originValue  value to check
     * @param defaultValue value default
     * @return result value
     */
    public static <T> T checkNotNull(T originValue, T defaultValue) {
        if (null == originValue) {
            return defaultValue;
        } else {
            return originValue;
        }
    }

    /**
     * Load image .
     * @param url image's url
     */
    public static RequestCreator load(String url) {
        return Picasso.with(App.getAppContext()).load(url).fit().centerCrop();
    }

    public static void showToast(int resId) {
        try {
            showToast(App.getAppContext().getString(resId));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showToast(String message) {
        if (null != message) {
            Toast.makeText(App.getAppContext(), message, Toast.LENGTH_SHORT).show();
        }
    }

    public static String getString(int strId) {
        String result = "";
        try {
            result = App.getAppContext().getString(strId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
