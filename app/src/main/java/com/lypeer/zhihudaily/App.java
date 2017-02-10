package com.lypeer.zhihudaily;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by lypeer on 2017/2/6.
 */

public class App extends Application {

    @SuppressLint("StaticFieldLeak")
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;

        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }

    public static Context getAppContext(){
        return mContext;
    }
}
