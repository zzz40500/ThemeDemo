package com.mingle.skin;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by zzz40500 on 15/8/27.
 */
public class SkinConfig {




    public  static  SkinStyle getSkinStyle(Context context){


        SharedPreferences sharedPreferences= context.getSharedPreferences("SkinStyle",
                Activity.MODE_PRIVATE);
         boolean nightMode=sharedPreferences.getBoolean("nightMode",false);


        return nightMode?SkinStyle.Dark:SkinStyle.Light;
    }


    public  static  void setSkinStyle(Context context,SkinStyle skinStyle){



        SharedPreferences.Editor editor= context.getSharedPreferences("SkinStyle",
                Activity.MODE_PRIVATE).edit();

                editor.putBoolean("nightMode",skinStyle== SkinStyle.Dark).apply();


    }

}
