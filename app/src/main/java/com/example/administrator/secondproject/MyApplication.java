package com.example.administrator.secondproject;

import android.app.Application;
import android.os.SystemClock;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/9/29.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SystemClock.sleep(TimeUnit.SECONDS.toMillis(3));
    }
}
