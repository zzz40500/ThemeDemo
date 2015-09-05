package com.mingle.skin.hepler;

import android.annotation.TargetApi;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.mingle.skin.SkinStyle;

/**
 * Created by zzz40500 on 15/9/4.
 */
public class LinearLayoutSkinHelper extends ViewSkinHelper {


    private int mDividerRes;
    private int mDarkDividerRes;


    @Override
    public void init(View view, AttributeSet attrs) {
        super.init(view, attrs);
        if (attrs == null) {
            mEnable = false;
            return;
        }

        mDividerRes = attrs.getAttributeResourceValue(ANDROIDXML, "divider", -1);
        mDarkDividerRes = attrs.getAttributeResourceValue(MATERIALDESIGNXML, "nightDivider", -1);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void setSkinStyle(SkinStyle skinStyle) {
        if(!mEnable){
            return;
        }

        super.setSkinStyle(skinStyle);
        if (skinStyle == SkinStyle.Light) {
            if (mDividerRes != -1) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                    LinearLayout linearLayout = (LinearLayout) mView;
                    try {
                        linearLayout.setDividerDrawable(mView.getResources().getDrawable(mDividerRes));

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        } else {

            if (mDarkDividerRes != -1) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                    LinearLayout linearLayout = (LinearLayout) mView;
                    try {
                        linearLayout.setDividerDrawable(mView.getResources().getDrawable(mDarkDividerRes));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        }

    }


}
