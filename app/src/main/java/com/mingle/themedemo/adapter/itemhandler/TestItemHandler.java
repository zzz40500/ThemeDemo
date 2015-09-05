package com.mingle.themedemo.adapter.itemhandler;

import android.view.View;

import com.mingle.skin.hepler.SkinCompat;
import com.mingle.themedemo.R;

import kale.adapter.handler.SimpleItemHandler;
import kale.adapter.util.ViewHolder;

/**
 * Created by zzz40500 on 15/9/5.
 */
public class TestItemHandler  extends SimpleItemHandler<String> {


    @Override
    public void onBindView33(ViewHolder viewHolder, String s, int i) {

        SkinCompat.setCurrentTheme(viewHolder.getConvertView(),null);

    }

    @Override
    public void onClick(View view, String s, int i) {

    }

    @Override
    public int getLayoutResId() {
        return R.layout.item_test;
    }
}
