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

    private int nightTextColor;
    private int nightTextColorRes;
    private int nightTextColorHighlight;
    private int nightTextColorAppearance;

    private int nightTextColorLinkRes;
    private int nightTextColorLink;

    private int nightTextColorHintRes;
    private int nightTextColorHint;


    private int lightTextColor;
    private int lightTextColorRes;
    private int lightTextColorHighlight;

    private int ligghtTextAppearance;

    private int lightTextColorLinkRes;
    private int lightTextColorLink;
    private int lightTextColorHintRes;
    private int lightTextColorHint;



    @Override
    public void init(View view, AttributeSet attrs) {
        super.init(view, attrs);
        if(attrs == null){
            enble=false;
            return;
        }

        lightTextColorRes = attrs.getAttributeResourceValue(ANDROIDXML, "textColor", -1);
        if (lightTextColorRes == -1) {
            lightTextColor = attrs.getAttributeIntValue(ANDROIDXML, "textColor", -1);
        }

        int lightTextColorHighlightRes = attrs.getAttributeResourceValue(ANDROIDXML, "textColorHighlight", -1);
        if (lightTextColorHighlightRes == -1) {
            lightTextColorHighlight = attrs.getAttributeIntValue(ANDROIDXML, "textColorHighlight", -1);
        } else {
            lightTextColorHighlight = view.getContext().getResources().getColor(lightTextColorHighlightRes);
        }

        lightTextColorLinkRes = attrs.getAttributeResourceValue(ANDROIDXML, "textColorLink", -1);
        if (lightTextColorLinkRes == -1) {
            lightTextColorLink = attrs.getAttributeIntValue(ANDROIDXML, "textColorLink", -1);
        }


        lightTextColorHintRes = attrs.getAttributeResourceValue(ANDROIDXML, "textColorHint", -1);
        if (lightTextColorHintRes == -1) {
            lightTextColorHint = attrs.getAttributeIntValue(ANDROIDXML, "textColorHint", -1);
        }

        ligghtTextAppearance = attrs.getAttributeResourceValue(ANDROIDXML, "textAppearance", -1);


        nightTextColorRes = attrs.getAttributeResourceValue(MATERIALDESIGNXML, "nightTextColor", -1);
        if (nightTextColorRes == -1) {
            nightTextColor = attrs.getAttributeIntValue(MATERIALDESIGNXML, "nightTextColor", -1);
        }

        int nightTextColorHighlightRes = attrs.getAttributeResourceValue(MATERIALDESIGNXML, "nightTextColorHighlight", -1);
        if (nightTextColorHighlightRes != -1) {
            nightTextColorHighlight = view.getContext().getResources().getColor(nightTextColorHighlightRes);

        } else {
            nightTextColorHighlight = attrs.getAttributeIntValue(MATERIALDESIGNXML, "nightTextColorHighlight", -1);

        }

        nightTextColorLinkRes = attrs.getAttributeResourceValue(MATERIALDESIGNXML, "nightTextColorLink", -1);
        if (nightTextColorLinkRes == -1) {
            nightTextColorLink = attrs.getAttributeIntValue(MATERIALDESIGNXML, "nightTextColorLink", -1);
        }


        nightTextColorHintRes = attrs.getAttributeResourceValue(MATERIALDESIGNXML, "nightTextColorHint", -1);
        if (nightTextColorHintRes == -1) {
            nightTextColorHint = attrs.getAttributeIntValue(MATERIALDESIGNXML, "nightTextColorHint", -1);
        }
        nightTextColorAppearance = attrs.getAttributeResourceValue(MATERIALDESIGNXML, "nightTextColorAppearance", -1);
    }

    @Override
    public void setSkinStyle(SkinStyle skinStyle) {
        super.setSkinStyle(skinStyle);
        if (skinStyle == SkinStyle.Dark) {
            TextView tv = (TextView) mView;
            if (nightTextColorAppearance != -1) {
                tv.setTextAppearance(tv.getContext(), nightTextColorAppearance);
            }


            if (nightTextColorRes != -1) {
                tv.setTextColor(mView.getResources().getColorStateList(nightTextColorRes));
            } else if (nightTextColor != -1) {
                tv.setTextColor(nightTextColor);
            }
            if (nightTextColorHighlight != -1) {
                tv.setHighlightColor(nightTextColorHighlight);
            }

            if (nightTextColorLinkRes != -1) {
                tv.setLinkTextColor(mView.getResources().getColorStateList(nightTextColorLinkRes));
            } else if (nightTextColorLink != -1) {
                tv.setLinkTextColor(nightTextColorLink);
            }
            if (nightTextColorHintRes != -1) {
                tv.setHintTextColor(mView.getResources().getColorStateList(nightTextColorHintRes));
            } else if (nightTextColorHint != -1) {
                tv.setHintTextColor(nightTextColorHint);
            }



        }else{



            TextView tv = (TextView) mView;

            if (ligghtTextAppearance != -1) {
                tv.setTextAppearance(tv.getContext(), ligghtTextAppearance);

            }
            if (lightTextColorRes != -1) {
                tv.setTextColor(mView.getResources().getColorStateList(lightTextColorRes));
            } else if (lightTextColor != -1) {
                tv.setTextColor(lightTextColor);
            }
            if (lightTextColorHighlight != -1) {
                tv.setHighlightColor(lightTextColorHighlight);
            }

            if (lightTextColorLinkRes != -1) {
                tv.setLinkTextColor(mView.getResources().getColorStateList(lightTextColorLinkRes));
            } else if (lightTextColorLink != -1) {
                tv.setLinkTextColor(lightTextColorLink);
            }
            if (lightTextColorHintRes != -1) {
                tv.setHintTextColor(mView.getResources().getColorStateList(lightTextColorHintRes));
            } else if (lightTextColorHint != -1) {
                tv.setHintTextColor(lightTextColorHint);
            }



        }
    }
}
