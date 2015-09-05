package com.mingle.skin.hepler;


import android.util.AttributeSet;
import android.view.View;

import com.mingle.skin.SkinConfig;
import com.mingle.skin.SkinStyle;

/**
 * @attr ref android.R.styleable#View_background
 * Created by zzz40500 on 15/9/3.
 */
public class ViewSkinHelper extends SkinHelper {


    protected final static String MATERIALDESIGNXML = "http://schemas.android.com/apk/res-auto";
    protected final static String ANDROIDXML = "http://schemas.android.com/apk/res/android";

    protected View mView;
    protected SkinStyle mSkinStyle = SkinStyle.Light;
    private int mLightBackgroundRes = -1;
    private int mLightBackgroundColor = -1;

    private int mDarkBackgroundRes = -1;
    private int mDarkBackgroundColor = -1;


    public boolean mEnable =true;


    /**
     * 设置背景色
     * Set background Color
     */
    public void init(View view, AttributeSet attrs) {
        mView = view;

        if(attrs == null){
            mEnable =false;
            return;
        }

        mLightBackgroundRes = attrs.getAttributeResourceValue(ANDROIDXML, "background", -1);
        mDarkBackgroundRes = attrs.getAttributeResourceValue(MATERIALDESIGNXML, "nightBackground", -1);

        if (mLightBackgroundRes == -1) {
            mLightBackgroundColor = attrs.getAttributeIntValue(ANDROIDXML, "background", -1);
        }
        if (mDarkBackgroundRes == -1) {
            mDarkBackgroundColor = attrs.getAttributeIntValue(MATERIALDESIGNXML, "nightBackground", -1);
        }

    }

    public void setSkinStyle(SkinStyle skinStyle) {

        if(!mEnable){
            return;
        }


        if (skinStyle == SkinStyle.Light) {

            if (mLightBackgroundRes != -1) {
                mView.setBackgroundResource(mLightBackgroundRes);
            } else if (mLightBackgroundColor != -1) {
                mView.setBackgroundColor(mLightBackgroundColor);
            }
        } else {

            if (mDarkBackgroundRes != -1) {

                mView.setBackgroundResource(mDarkBackgroundRes);
            } else if (mDarkBackgroundColor != -1) {

                mView.setBackgroundColor(mDarkBackgroundColor);
            }

        }

    }

    @Override
    public void setCurrentTheme() {

        if(SkinConfig.getSkinStyle(mView.getContext())== SkinStyle.Dark){
            setSkinStyle(SkinStyle.Dark);
        }


    }


}
