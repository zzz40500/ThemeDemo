package com.mingle.skin.hepler;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

import com.mingle.skin.SkinConfig;
import com.mingle.skin.SkinEnable;
import com.mingle.skin.SkinStyle;
import com.mingle.widget.SLayoutParamsI;

/**
 * Created by zzz40500 on 15/9/4.
 */
public class SkinCompat {




    public interface SkinStyleChangeListener {
       void beforeChange();
       void afterChange();

    }

    /**
     *
     * @param activity 当前 Activity
     * @param skinStyle Dark(夜间),Light(日间)
     * @param skinStyleChangeListener (转换监听器)
     */
    public static void setSkinStyle(Activity activity, SkinStyle skinStyle,SkinStyleChangeListener skinStyleChangeListener) {

        if(skinStyleChangeListener != null)
        skinStyleChangeListener.beforeChange();
//        if(SkinConfig.getSkinStyle(activity)!=skinStyle){
            View view=  ((ViewGroup)activity.findViewById(android.R.id.content)).getChildAt(0);
            changeSkinStyle(view, skinStyle);
            SkinConfig.setSkinStyle(activity,skinStyle);
//      }
        if(skinStyleChangeListener != null)
        skinStyleChangeListener.afterChange();
    }

    public static void setCurrentTheme(View v,SkinStyleChangeListener skinStyleChangeListener) {

        if(skinStyleChangeListener != null)
        skinStyleChangeListener.beforeChange();
        changeSkinStyle(v, SkinConfig.getSkinStyle(v.getContext()));
        if(skinStyleChangeListener != null)
        skinStyleChangeListener.afterChange();


    }
    public static void setCurrentTheme(Activity activity,SkinStyleChangeListener skinStyleChangeListener) {




        if(skinStyleChangeListener != null)
        skinStyleChangeListener.beforeChange();
        setSkinStyle(activity,SkinConfig.getSkinStyle(activity),null);
        if(skinStyleChangeListener != null)
        skinStyleChangeListener.afterChange();


    }



    public static void changeSkinStyle(View view, SkinStyle skinStyle) {


        if (view instanceof SkinEnable) {

            ((SkinEnable) view).setSkinStyle(skinStyle);
        }else{

            ViewGroup.LayoutParams params=   view.getLayoutParams();
            if(params instanceof SLayoutParamsI){
                ((SLayoutParamsI) params).setSkinStyle(skinStyle);
            }

        }

        if (view instanceof ViewGroup) {

            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {

                View v = ((ViewGroup) view).getChildAt(i);

                changeSkinStyle(v, skinStyle);

            }

        }


    }


}
