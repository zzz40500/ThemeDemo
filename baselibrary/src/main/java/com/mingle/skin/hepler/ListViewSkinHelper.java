package com.mingle.skin.hepler;

import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

import com.mingle.baselibrary.R;
import com.mingle.skin.SkinStyle;

/**
 * Created by zzz40500 on 15/9/4.
 */
public class ListViewSkinHelper extends ViewSkinHelper {


    private int nightLVDivider = -1;
    private int nightLVDividerRes = -1;
    private int divider = -1;
    private int dividerRes = -1;
    private int dividerHeight = -1;

    @Override
    public void init(View view, AttributeSet attrs) {
        super.init(view, attrs);

        if (attrs == null) {
            enble = false;
            return;
        }


        dividerRes = attrs.getAttributeResourceValue(ANDROIDXML, "divider", -1);
        dividerHeight = attrs.getAttributeResourceValue(ANDROIDXML, "dividerHeight", -1);
        if (dividerRes == -1) {
            divider = attrs.getAttributeIntValue(ANDROIDXML, "divider", -1);
        }


        nightLVDividerRes = attrs.getAttributeResourceValue(MATERIALDESIGNXML, "nightLVDivider", -1);
        if (nightLVDividerRes != -1) {
            nightLVDivider = attrs.getAttributeIntValue(MATERIALDESIGNXML, "nightLVDivider", -1);
        }

    }

    @Override
    public void setSkinStyle(SkinStyle skinStyle) {
        super.setSkinStyle(skinStyle);
        ListView listView = (ListView) mView;
        int dividerHeight = listView.getDividerHeight();

        if (dividerHeight == -1) {
            return;
        }

        if (skinStyle == SkinStyle.Dark) {

            if (nightLVDividerRes != -1) {

                try {
                    listView.setDivider(new ColorDrawable(mView.getContext().getResources().getColor(nightLVDividerRes)));

                } catch (Exception e) {
                    try {
                        listView.setDivider(mView.getContext().getResources().getDrawable(nightLVDividerRes));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                listView.setDividerHeight(dividerHeight);

            } else if (nightLVDivider != -1) {
                listView.setDivider(new ColorDrawable(nightLVDivider));
                listView.setDividerHeight(dividerHeight);

            } else {
                listView.setDivider(null);
                listView.setDividerHeight(dividerHeight);

            }

        } else {

            if (dividerRes != -1) {

                try {
                    listView.setDivider(new ColorDrawable(mView.getContext().getResources().getColor(dividerRes)));

                } catch (Exception e) {
                    try {
                    listView.setDivider(mView.getContext().getResources().getDrawable(dividerRes));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                listView.setDividerHeight(dividerHeight);
            } else if (divider != -1) {
                listView.setDivider(new ColorDrawable(divider));
                listView.setDividerHeight(dividerHeight);
            } else {
                listView.setDivider(null);
                listView.setDividerHeight(dividerHeight);

            }

        }
    }
}
