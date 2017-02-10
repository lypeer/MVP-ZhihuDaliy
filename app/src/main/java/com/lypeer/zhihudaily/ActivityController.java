package com.lypeer.zhihudaily;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Collect and control all the activities
 * Created by lypeer on 16-5-6.
 */
public class ActivityController {
    /**
     * List of activities alive
     */
    public static final List<Activity> sActivities = new ArrayList<>();

    /**
     * add activity to the list.
     *
     * @param activity target activity
     */
    public static void addActivity(Activity activity) {
        sActivities.add(activity);
    }

    /**
     * remove activity in the list
     *
     * @param activity target activity
     */
    public static void removeActivity(Activity activity) {
        sActivities.remove(activity);
    }

    /**
     * clear the list
     */
    public static void finishAll() {
        for (Activity activity : sActivities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }

    /**
     * clear the list except current activity
     */
    public static void finishAllExceptNow(Activity targetActivity) {
        for (Activity activity : sActivities) {
            if (activity != targetActivity && !activity.isFinishing()) {
                activity.finish();
            }
        }
    }

    /**
     * to check if the target activity alive
     *
     * @param activityName name of target activity
     * @return true if it is alive , false if it's not alive
     */
    public static boolean isTargetActivityAlive(String activityName) {
        for (Activity activity : sActivities) {
            if (activity.getClass().getSimpleName().equals(activityName)) {
                return true;
            }
        }
        return false;
    }

    public static String getVersion() {
        try {
            PackageManager manager = App.getAppContext().getPackageManager();
            PackageInfo info = manager.getPackageInfo(App.getAppContext().getPackageName(), 0);
            return info.versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
