package com.dim.themedemo;

import android.app.Application;
import android.support.v7.app.SkinHelper;

/**
 * Created by zzz40500 on 16/5/24.
 */
public class APP extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SkinHelper.init(this);
    }
}
