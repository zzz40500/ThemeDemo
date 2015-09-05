package com.mingle.skin.hepler;

import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

import com.mingle.skin.SkinStyle;

/**
 * Created by zzz40500 on 15/9/4.
 */
public class ListViewSkinHelper extends ViewSkinHelper {


    private int mNightLVDivider = -1;
    private int mNightLVDividerRes = -1;
    private int mDivider = -1;
    private int mDividerRes = -1;

    @Override
    public void init(View view, AttributeSet attrs) {
        super.init(view, attrs);

        if (attrs == null) {
            mEnable = false;
            return;
        }


        mDividerRes = attrs.getAttributeResourceValue(ANDROIDXML, "divider", -1);
        if (mDividerRes == -1) {
            mDivider = attrs.getAttributeIntValue(ANDROIDXML, "divider", -1);
        }


        mNightLVDividerRes = attrs.getAttributeResourceValue(MATERIALDESIGNXML, "nightLVDivider", -1);
        if (mNightLVDividerRes != -1) {
            mNightLVDivider = attrs.getAttributeIntValue(MATERIALDESIGNXML, "nightLVDivider", -1);
        }

    }

    @Override
    public void setSkinStyle(SkinStyle skinStyle) {
        if(!mEnable){
            return;
        }
        super.setSkinStyle(skinStyle);

        ListView listView = (ListView) mView;
        int dividerHeight = listView.getDividerHeight();

        if (dividerHeight == -1) {
            return;
        }

        if (skinStyle == SkinStyle.Dark) {

            if (mNightLVDividerRes != -1) {

                try {
                    listView.setDivider(new ColorDrawable(mView.getContext().getResources().getColor(mNightLVDividerRes)));

                } catch (Exception e) {
                    try {
                        listView.setDivider(mView.getContext().getResources().getDrawable(mNightLVDividerRes));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                listView.setDividerHeight(dividerHeight);

            } else if (mNightLVDivider != -1) {
                listView.setDivider(new ColorDrawable(mNightLVDivider));
                listView.setDividerHeight(dividerHeight);

            } else {
                listView.setDivider(null);
                listView.setDividerHeight(dividerHeight);

            }

        } else {

            if (mDividerRes != -1) {

                try {
                    listView.setDivider(new ColorDrawable(mView.getContext().getResources().getColor(mDividerRes)));

                } catch (Exception e) {
                    try {
                    listView.setDivider(mView.getContext().getResources().getDrawable(mDividerRes));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                listView.setDividerHeight(dividerHeight);
            } else if (mDivider != -1) {
                listView.setDivider(new ColorDrawable(mDivider));
                listView.setDividerHeight(dividerHeight);
            } else {
                listView.setDivider(null);
                listView.setDividerHeight(dividerHeight);

            }

        }
    }
}
