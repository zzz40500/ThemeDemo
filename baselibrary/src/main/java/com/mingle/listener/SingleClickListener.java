package com.mingle.listener;

import android.view.View;


/**
 * Created by zzz40500 on 15/8/26.
 */
public class SingleClickListener implements View.OnClickListener {

    private View.OnClickListener mListener;

    private SingleClickHelper singleClickhelper =new SingleClickHelper();

    public SingleClickListener(View.OnClickListener mListener) {
        this.mListener = mListener;
    }

    @Override
    public void onClick(View v) {

        if (singleClickhelper.clickEnable()&& mListener != null) {
            mListener.onClick(v);
        }
    }
}
