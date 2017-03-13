package ${packageName};

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;


public class App extends Application {

    @SuppressLint("StaticFieldLeak")
    private static Context mContext = null;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getAppContext(){
        return mContext;
    }
}
