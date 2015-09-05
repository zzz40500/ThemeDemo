package com.mingle.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.*;
import android.view.View;
import android.widget.*;
import android.widget.LinearLayout;

import com.mingle.circletreveal.CircleRevealEnable;
import com.mingle.circletreveal.CircleRevealHelper;
import com.mingle.listener.SingleClickListener;
import com.mingle.skin.SkinEnable;
import com.mingle.skin.SkinStyle;
import com.mingle.skin.hepler.DefaultViewSkinHelper;
import com.mingle.skin.hepler.SkinHelper;
import com.mingle.widget.animation.CRAnimation;


/**
 * Created by zzz40500 on 15/8/26.
 */
public class RelativeLayout  extends android.widget.RelativeLayout  implements CircleRevealEnable,SkinEnable {

    private CircleRevealHelper mCircleRevealHelper ;
    private SkinHelper mSkinHelper;

    public RelativeLayout(Context context) {
        super(context);
        init(null);

    }

    public RelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    private void init(AttributeSet attrs) {

        mSkinHelper=SkinHelper.create(this);
        mSkinHelper.init(this, attrs);
        mSkinHelper.setCurrentTheme();
        mCircleRevealHelper=new CircleRevealHelper(this);
    }

    public RelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }


    @Override
    public void setOnClickListener(OnClickListener l) {
        super.setOnClickListener(new SingleClickListener(l));
    }

    @Override
    public void draw(Canvas canvas) {
        mCircleRevealHelper.draw(canvas);
    }


    @Override
    public void superDraw(Canvas canvas) {
        super.draw(canvas);
    }


    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        super.addView(child, index, params);
        if(params instanceof SLayoutParams){
            ((SLayoutParams) params).setSkinHelper(child);
        }
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {


        return new SLayoutParams(getContext(),attrs);
    }

    @Override
    public CRAnimation circularReveal(int centerX, int centerY, float startRadius, float endRadius) {
        return mCircleRevealHelper.circularReveal(centerX,centerY,startRadius,endRadius);
    }

    @Override
    public void setSkinStyle(SkinStyle skinStyle) {
        mSkinHelper.setSkinStyle(skinStyle);
    }


    public  class  SLayoutParams extends android.widget.RelativeLayout.LayoutParams implements SLayoutParamsI  {

        private DefaultViewSkinHelper mSkinHelper;

        public SLayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            mSkinHelper=SkinHelper.createDeFault();
            mSkinHelper.init(null,attrs);
        }

        public void setSkinHelper(android.view.View view){
            mSkinHelper.setView(view);
        }
        public void setSkinStyle(SkinStyle skinStyle){
            mSkinHelper.setSkinStyle(skinStyle);
        }

        public SLayoutParams(int width, int height) {
            super(width, height);
        }


        public SLayoutParams(ViewGroup.LayoutParams p) {
            super(p);
        }

        public SLayoutParams(MarginLayoutParams source) {
            super(source);
        }

        @TargetApi(Build.VERSION_CODES.KITKAT)
        public SLayoutParams(android.widget.RelativeLayout.LayoutParams source) {
            super(source);
        }
    }
}
