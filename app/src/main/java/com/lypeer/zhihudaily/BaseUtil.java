package com.lypeer.zhihudaily;

import android.app.Application;
import android.view.View;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

/**
 * Created by lypeer on 2017/2/5.
 */

public class BaseUtil {

    public static String checkNotNull(String origin) {
        return checkNotNull(origin, "");
    }

    public static <T> T checkNotNull(T origin, T result) {
        if (null == origin) {
            return result;
        } else {
            return origin;
        }
    }

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
