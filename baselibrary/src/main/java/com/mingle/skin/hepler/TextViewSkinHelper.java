package com.mingle.skin.hepler;

import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.mingle.skin.SkinStyle;

/**
 * <attr name="nightTextColor" format="color"/>
 * <attr name="nightTextColorHighlight" format="color"/>
 * <attr name="nightTextColorAppearance" format="reference"/>
 * <attr name="nightTextColorLink" format="reference"/>
 * textColorHint
 * Created by zzz40500 on 15/9/4.
 */
public class TextViewSkinHelper extends ViewSkinHelper {

    private int mNightTextColor;
    private int mNightTextColorRes;
    private int mNightTextColorHighlight;
    private int mNightTextColorAppearance;

    private int mNightTextColorLinkRes;
    private int mNightTextColorLink;

    private int mNightTextColorHintRes;
    private int mNightTextColorHint;


    private int mLightTextColor;
    private int mLightTextColorRes;
    private int mLightTextColorHighlight;

    private int ligghtTextAppearance;

    private int mLightTextColorLinkRes;
    private int mLightTextColorLink;
    private int mLightTextColorHintRes;
    private int mLightTextColorHint;



    @Override
    public void init(View view, AttributeSet attrs) {
        super.init(view, attrs);
        if (attrs == null) {
            mEnable = false;
            return;
        }

        mLightTextColorRes = attrs.getAttributeResourceValue(ANDROIDXML, "textColor", -1);
        if (mLightTextColorRes == -1) {
            mLightTextColor = attrs.getAttributeIntValue(ANDROIDXML, "textColor", -1);
        }

        int mLightTextColorHighlightRes = attrs.getAttributeResourceValue(ANDROIDXML, "textColorHighlight", -1);
        if (mLightTextColorHighlightRes == -1) {
            mLightTextColorHighlight = attrs.getAttributeIntValue(ANDROIDXML, "textColorHighlight", -1);
        } else {
            mLightTextColorHighlight = view.getContext().getResources().getColor(mLightTextColorHighlightRes);
        }

        mLightTextColorLinkRes = attrs.getAttributeResourceValue(ANDROIDXML, "textColorLink", -1);
        if (mLightTextColorLinkRes == -1) {
            mLightTextColorLink = attrs.getAttributeIntValue(ANDROIDXML, "textColorLink", -1);
        }


        mLightTextColorHintRes = attrs.getAttributeResourceValue(ANDROIDXML, "textColorHint", -1);
        if (mLightTextColorHintRes == -1) {
            mLightTextColorHint = attrs.getAttributeIntValue(ANDROIDXML, "textColorHint", -1);
        }

        ligghtTextAppearance = attrs.getAttributeResourceValue(ANDROIDXML, "textAppearance", -1);


        mNightTextColorRes = attrs.getAttributeResourceValue(MATERIALDESIGNXML, "nightTextColor", -1);
        if (mNightTextColorRes == -1) {
            mNightTextColor = attrs.getAttributeIntValue(MATERIALDESIGNXML, "nightTextColor", -1);
        }

        int mNightTextColorHighlightRes = attrs.getAttributeResourceValue(MATERIALDESIGNXML, "nightTextColorHighlight", -1);
        if (mNightTextColorHighlightRes != -1) {
            mNightTextColorHighlight = view.getContext().getResources().getColor(mNightTextColorHighlightRes);

        } else {
            mNightTextColorHighlight = attrs.getAttributeIntValue(MATERIALDESIGNXML, "nightTextColorHighlight", -1);

        }

        mNightTextColorLinkRes = attrs.getAttributeResourceValue(MATERIALDESIGNXML, "nightTextColorLink", -1);
        if (mNightTextColorLinkRes == -1) {
            mNightTextColorLink = attrs.getAttributeIntValue(MATERIALDESIGNXML, "nightTextColorLink", -1);
        }


        mNightTextColorHintRes = attrs.getAttributeResourceValue(MATERIALDESIGNXML, "nightTextColorHint", -1);
        if (mNightTextColorHintRes == -1) {
            mNightTextColorHint = attrs.getAttributeIntValue(MATERIALDESIGNXML, "nightTextColorHint", -1);
        }
        mNightTextColorAppearance = attrs.getAttributeResourceValue(MATERIALDESIGNXML, "nightTextColorAppearance", -1);
    }

    @Override
    public void setSkinStyle(SkinStyle skinStyle) {
        if(!mEnable){
            return;
        }
        super.setSkinStyle(skinStyle);
        if (skinStyle == SkinStyle.Dark) {
            TextView tv = (TextView) mView;
            if (mNightTextColorAppearance != -1) {
                tv.setTextAppearance(tv.getContext(), mNightTextColorAppearance);
            }


            if (mNightTextColorRes != -1) {
                tv.setTextColor(mView.getResources().getColorStateList(mNightTextColorRes));
            } else if (mNightTextColor != -1) {
                tv.setTextColor(mNightTextColor);
            }
            if (mNightTextColorHighlight != -1) {
                tv.setHighlightColor(mNightTextColorHighlight);
            }

            if (mNightTextColorLinkRes != -1) {
                tv.setLinkTextColor(mView.getResources().getColorStateList(mNightTextColorLinkRes));
            } else if (mNightTextColorLink != -1) {
                tv.setLinkTextColor(mNightTextColorLink);
            }
            if (mNightTextColorHintRes != -1) {
                tv.setHintTextColor(mView.getResources().getColorStateList(mNightTextColorHintRes));
            } else if (mNightTextColorHint != -1) {
                tv.setHintTextColor(mNightTextColorHint);
            }



        }else{



            TextView tv = (TextView) mView;

            if (ligghtTextAppearance != -1) {
                tv.setTextAppearance(tv.getContext(), ligghtTextAppearance);

            }
            if (mLightTextColorRes != -1) {
                tv.setTextColor(mView.getResources().getColorStateList(mLightTextColorRes));
            } else if (mLightTextColor != -1) {
                tv.setTextColor(mLightTextColor);
            }
            if (mLightTextColorHighlight != -1) {
                tv.setHighlightColor(mLightTextColorHighlight);
            }

            if (mLightTextColorLinkRes != -1) {
                tv.setLinkTextColor(mView.getResources().getColorStateList(mLightTextColorLinkRes));
            } else if (mLightTextColorLink != -1) {
                tv.setLinkTextColor(mLightTextColorLink);
            }
            if (mLightTextColorHintRes != -1) {
                tv.setHintTextColor(mView.getResources().getColorStateList(mLightTextColorHintRes));
            } else if (mLightTextColorHint != -1) {
                tv.setHintTextColor(mLightTextColorHint);
            }



        }
    }
}
