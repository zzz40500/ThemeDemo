package com.mingle.themedemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.MAppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.mingle.circletreveal.CircularRevealCompat;
import com.mingle.skin.SkinConfig;
import com.mingle.skin.SkinStyle;
import com.mingle.skin.hepler.SkinCompat;
import com.mingle.widget.EditText;
import com.mingle.widget.WidgetFactor;
import com.mingle.widget.animation.CRAnimation;
import com.mingle.widget.animation.SimpleAnimListener;

public class MainActivity extends MAppCompatActivity implements View.OnClickListener {


    private RelativeLayout mRl;
    private FloatingActionButton mFloatingActionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        mRl = (RelativeLayout) findViewById(R.id.rl);
        setSupportActionBar(toolbar);
        mFloatingActionButton = (FloatingActionButton) findViewById(R.id.fb);



        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, ListViewDemoActivity.class));
            }
        });
        mFloatingActionButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {


        CRAnimation crA =
                new CircularRevealCompat(mRl).circularReveal(v.getLeft() + v.getWidth() / 2, v.getTop() + v.getHeight() / 2, mRl.getHeight(), 0);

        if (crA != null) {
            crA.addListener(new SimpleAnimListener() {
                @Override
                public void onAnimationEnd(CRAnimation animation) {
                    super.onAnimationEnd(animation);
                    mRl.setVisibility(View.GONE);
                    SkinStyle skinStyle = null;
                    if (SkinConfig.getSkinStyle(MainActivity.this) == SkinStyle.Dark) {
                        skinStyle = SkinStyle.Light;
                    } else {
                        skinStyle = SkinStyle.Dark;
                    }
                    SkinCompat.setSkinStyle(MainActivity.this, skinStyle, mSkinStyleChangeListenerImp) ;
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

                    CRAnimation crA =
                            new CircularRevealCompat(mRl).circularReveal(
                                    mFloatingActionButton.getLeft() + mFloatingActionButton.getWidth() / 2, mFloatingActionButton.getTop() + mFloatingActionButton.getHeight() / 2, 0, mRl.getHeight());

                    if (crA != null)
                        crA.start();
                }
            },600);


        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
