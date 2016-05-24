package com.dim.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

import com.dim.circletreveal.CircleRevealHelper;
import com.dim.skin.SkinStyle;
import com.dim.circletreveal.CircleRevealEnable;
import com.dim.listener.SingleClickListener;
import com.dim.listener.SingleItemClickListener;
import com.dim.skin.SkinEnable;
import com.dim.skin.hepler.SkinHelper;
import com.dim.widget.animation.CRAnimation;


/**
 * Created by zzz40500 on 15/8/26.
 */
public class ListView extends android.widget.ListView implements CircleRevealEnable,SkinEnable {

    private CircleRevealHelper mCircleRevealHelper ;
    private SkinHelper mSkinHelper;



    public ListView(Context context) {
        super(context);
        init(null);

    }


    public ListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    private void init(AttributeSet attrs) {

        mSkinHelper=SkinHelper.create(this);
        mSkinHelper.init(this, attrs);
        mSkinHelper.setCurrentTheme();
        mCircleRevealHelper=new CircleRevealHelper(this);
    }

    public ListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }


    @Override
    public void setOnClickListener(OnClickListener l) {
        super.setOnClickListener(new SingleClickListener(l));
    }

    @Override
    public void setOnItemClickListener(OnItemClickListener listener) {
        super.setOnItemClickListener(new SingleItemClickListener(listener));
    }

    @Override
    public void draw(Canvas canvas) {

        mSkinHelper.preDraw(this);
        mCircleRevealHelper.draw(canvas);
    }


    @Override
    public void superDraw(Canvas canvas) {
        super.draw(canvas);
    }



    @Override
    public CRAnimation circularReveal(int centerX, int centerY, float startRadius, float endRadius) {
        return mCircleRevealHelper.circularReveal(centerX,centerY,startRadius,endRadius);
    }

    @Override
    public void setSkinStyle(SkinStyle skinStyle) {
        mSkinHelper.setSkinStyle(skinStyle);
    }
}
