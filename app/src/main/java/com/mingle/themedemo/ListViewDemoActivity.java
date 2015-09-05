package com.mingle.themedemo;

import android.os.Bundle;
import android.support.v7.app.MAppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import com.mingle.circletreveal.CircularRevealCompat;
import com.mingle.skin.SkinConfig;
import com.mingle.skin.SkinStyle;
import com.mingle.skin.hepler.SkinCompat;
import com.mingle.themedemo.adapter.itemhandler.TestItemHandler;
import com.mingle.widget.animation.CRAnimation;
import com.mingle.widget.animation.SimpleAnimListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kale.adapter.adapter.AutoAdapter;
import kale.adapter.handler.ItemHandler;

public class ListViewDemoActivity extends MAppCompatActivity implements View.OnClickListener {

    private View mRl;
    private List<String> mData=new ArrayList<>();
    private  int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_demo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        mRl =  findViewById(R.id.rl);
        ListView listView = (ListView) findViewById(R.id.listView);
        setSupportActionBar(toolbar);

        for (int i = 0; i < 20; i++) {
            mData.add("");
        }

        listView.setAdapter(new AutoAdapter(this, mData) {
            @Override
            protected void initHandlers(HashMap<Integer, ItemHandler> hashMap) {

                addHandler(0, new TestItemHandler());

            }

            @Override
            protected int getViewType(int i) {
                return 0;
            }
        });


        findViewById(R.id.button).setOnClickListener(this);



    }


    @Override
    public void onClick(View v) {
        CRAnimation crA =
                new CircularRevealCompat(mRl).circularReveal(mRl.getWidth() / 2, mRl.getHeight() / 2, mRl.getWidth(), 0);

        if (crA != null) {
            crA.addListener(new SimpleAnimListener() {
                @Override
                public void onAnimationEnd(CRAnimation animation) {
                    super.onAnimationEnd(animation);
                    mRl.setVisibility(View.GONE);
                    SkinStyle skinStyle = null;
                    if (SkinConfig.getSkinStyle(ListViewDemoActivity.this) == SkinStyle.Dark) {
                        skinStyle = SkinStyle.Light;
                    } else {
                        skinStyle = SkinStyle.Dark;
                    }
                    SkinCompat.setSkinStyle(ListViewDemoActivity.this, skinStyle, mSkinStyleChangeListenerImp) ;
                }
            });
            crA.start();

        }
    }
    private SkinStyleChangeListenerImp mSkinStyleChangeListenerImp=new SkinStyleChangeListenerImp();

    class SkinStyleChangeListenerImp implements SkinCompat.SkinStyleChangeListener {

        @Override
        public void beforeChange() {

        }

        @Override
        public void afterChange() {

            mRl.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mRl.setVisibility(View.VISIBLE);

                    mRl.setVisibility(View.VISIBLE);

                    CRAnimation crA =
                            new CircularRevealCompat(mRl).circularReveal(mRl.getWidth() / 2, mRl.getHeight() / 2, 0, mRl.getWidth());

                    if (crA != null)
                        crA.start();
                }
            },600);


        }

    }


}
