package com.mingle.skin.hepler;

import android.annotation.TargetApi;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.mingle.skin.SkinStyle;

/**
 * Created by zzz40500 on 15/9/4.
 */
public class LinearLayoutSkinHelper extends ViewSkinHelper {


    private int dividerRes;
    private int darkDividerRes;


    @Override
    public void init(View view, AttributeSet attrs) {
        super.init(view, attrs);
        if (attrs == null) {
            enble = false;
            return;
        }

        dividerRes = attrs.getAttributeResourceValue(ANDROIDXML, "divider", -1);
        darkDividerRes = attrs.getAttributeResourceValue(MATERIALDESIGNXML, "nightDivider", -1);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void setSkinStyle(SkinStyle skinStyle) {
        super.setSkinStyle(skinStyle);
        if (skinStyle == SkinStyle.Light) {
            if (dividerRes != -1) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                    LinearLayout linearLayout = (LinearLayout) mView;
                    try {
                        linearLayout.setDividerDrawable(mView.getResources().getDrawable(dividerRes));

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        } else {

            if (darkDividerRes != -1) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                    LinearLayout linearLayout = (LinearLayout) mView;
                    try {
                        linearLayout.setDividerDrawable(mView.getResources().getDrawable(darkDividerRes));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        }

    }


}
