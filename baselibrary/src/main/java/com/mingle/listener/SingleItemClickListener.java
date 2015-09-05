package com.mingle.listener;

import android.view.View;
import android.widget.AdapterView;
/**
 * Created by zzz40500 on 15/8/26.
 */
public class SingleItemClickListener implements AdapterView.OnItemClickListener {

    private AdapterView.OnItemClickListener singleItemClickListener;

    private SingleClickHelper singleClickhelper =new SingleClickHelper();

    public SingleItemClickListener(AdapterView.OnItemClickListener singleItemClickListener) {
        this.singleItemClickListener = singleItemClickListener;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        if(singleItemClickListener != null && singleClickhelper.clickEnable()){
            singleItemClickListener.onItemClick(parent, view, position, id);
        }
    }
}
