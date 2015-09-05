package com.mingle.listener;

import android.os.SystemClock;
/**
 * Created by zzz40500 on 15/8/26.
 */
public  class SingleClickHelper {

    private static long L_CLICK_INTERVAL = 1200;
    private long preClickTime;


    public boolean clickEnable(){
        long clickTime= SystemClock.elapsedRealtime();
        if ( clickTime - preClickTime > L_CLICK_INTERVAL){
            preClickTime=clickTime;
            return true;
        }
        return false;
    }
}
