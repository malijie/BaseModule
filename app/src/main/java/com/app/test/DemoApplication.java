package com.app.test;

import android.app.Application;

import com.base.http.base.HttpCenter;

/**
 * Created by malijie on 2017/11/1.
 */

public class DemoApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        HttpCenter.init(this);
    }
}
