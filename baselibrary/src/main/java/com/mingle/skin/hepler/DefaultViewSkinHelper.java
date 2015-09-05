package com.mingle.skin.hepler;


import android.util.AttributeSet;
import android.view.View;

import com.mingle.skin.SkinConfig;
import com.mingle.skin.SkinStyle;
import com.mingle.widget.TextView;

/**
 * @attr ref android.R.styleable#View_background
 * Created by zzz40500 on 15/9/3.
 */
public class DefaultViewSkinHelper extends SkinHelper {


    protected final static String MATERIALDESIGNXML = "http://schemas.android.com/apk/res-auto";
    protected final static String ANDROIDXML = "http://schemas.android.com/apk/res/android";

    protected View mView;
    protected SkinStyle mSkinStyle = SkinStyle.Light;
    private int mLightBackgroundRes = -1;
    private int mLightBackgroundColor = -1;

    private int mDarkBackgroundRes = -1;
    private int mDarkBackgroundColor = -1;

    private int nightTextColor;
    private int mNightTextColorRes;

    private int mLightTextColor;
    private int mLightTextColorRes;
    public boolean mEnable =true;


    /**
     * 设置背景色
     * Set background Color
     */
    public void init(View view, AttributeSet attrs) {
        mView = view;
        if (attrs == null) {
            mEnable = false;
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

        mLightTextColorRes = attrs.getAttributeResourceValue(ANDROIDXML, "textColor", -1);
        if (mLightTextColorRes == -1) {
            mLightTextColor = attrs.getAttributeIntValue(ANDROIDXML, "textColor", -1);
        }

        mNightTextColorRes = attrs.getAttributeResourceValue(MATERIALDESIGNXML, "nightTextColor", -1);
        if (mNightTextColorRes == -1) {
            nightTextColor = attrs.getAttributeIntValue(MATERIALDESIGNXML, "nightTextColor", -1);
        }
    }

    public void setView(View view){
        this.mView=view;
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

            if(mView instanceof TextView) {

                android.widget.TextView tv = (android.widget.TextView) mView;
                if (mNightTextColorRes != -1) {
                    tv.setTextColor(mView.getResources().getColorStateList(mNightTextColorRes));
                } else if (nightTextColor != -1) {
                    tv.setTextColor(nightTextColor);
                }
            }

        } else {

            if (mDarkBackgroundRes != -1) {
                mView.setBackgroundResource(mDarkBackgroundRes);
            } else if (mDarkBackgroundColor != -1) {
                mView.setBackgroundColor(mDarkBackgroundColor);
            }
            if(mView instanceof TextView) {

                android.widget.TextView tv= (android.widget.TextView) mView;
                if (mLightTextColorRes != -1) {
                    tv.setTextColor(mView.getResources().getColorStateList(mLightTextColorRes));
                } else if (mLightTextColor != -1) {
                    tv.setTextColor(mLightTextColor);
                }
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
