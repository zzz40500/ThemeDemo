package com.mingle.circletreveal;
import android.animation.Animator;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Region;
import android.os.Build;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

import com.mingle.listener.SimpleAnimationListener;
import com.mingle.widget.animation.CRAnimation;
import com.nineoldandroids.animation.ValueAnimator;


/**
 * Created by zzz40500 on 15/8/26.
 */
public class CircleRevealHelper {

    private ValueAnimator valueAnimator;

    public CircleRevealHelper(View view) {
        mView = view;


        if (view instanceof CircleRevealEnable) {
            mCircleRevealEnable = (CircleRevealEnable) view;
        } else {
            throw new RuntimeException("the View must implements CircleRevealEnable ");
        }
    }

    private Path mPath = new Path();
    private View mView;

    private int mAnchorX, mAnchorY;
    private float mRadius;

    private boolean isCircularReveal = false;


    private CircleRevealEnable mCircleRevealEnable;



    public CRAnimation circularReveal(int centerX, int centerY, float startRadius, float endRadius) {


        mAnchorX = centerX;
        mAnchorY = centerY;
        if (Build.VERSION.SDK_INT >= 21) {

            Animator animator = ViewAnimationUtils.createCircularReveal(
                    mView,
                    mAnchorX,
                    mAnchorY,
                    startRadius,
                    endRadius);
            animator.setDuration(1200);

            return new CRAnimation(animator);

        } else {


             valueAnimator = ValueAnimator.ofFloat(startRadius, endRadius);

            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    mRadius = (float) animation.getAnimatedValue();


                    mView.postInvalidate();
                }
            });
            valueAnimator.addListener(new SimpleAnimationListener() {
                @Override
                public void onAnimationStart(com.nineoldandroids.animation.Animator animation) {
                    isCircularReveal = true;
                }


                @Override
                public void onAnimationEnd(com.nineoldandroids.animation.Animator animation) {
                    isCircularReveal = false;
                }


                @Override
                public void onAnimationCancel(com.nineoldandroids.animation.Animator animation) {
                    isCircularReveal = false;
                }

            });

            valueAnimator.setDuration(1200);
            return  new CRAnimation(valueAnimator);

        }
    }




    public void draw(Canvas canvas) {
        if (valueAnimator != null && valueAnimator.isRunning()) {
            canvas.save();
            canvas.translate(0, 0);
            mPath.reset();
            mPath.addCircle(mAnchorX, mAnchorY, mRadius, Path.Direction.CCW);
            canvas.clipPath(mPath, Region.Op.REPLACE);
            mCircleRevealEnable.superDraw(canvas);
            canvas.restore();
        } else {
            mCircleRevealEnable.superDraw(canvas);
        }
    }


}
