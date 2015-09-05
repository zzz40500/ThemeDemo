package com.mingle.circletreveal;
import android.animation.Animator;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Region;
import android.os.Build;
import android.view.View;
import android.view.ViewAnimationUtils;

import com.mingle.widget.animation.CRAnimation;
import com.nineoldandroids.animation.ValueAnimator;


/**
 * Created by zzz40500 on 15/8/26.
 */
public class CircleRevealHelper {

    private ValueAnimator mValueAnimator;

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


             mValueAnimator = ValueAnimator.ofFloat(startRadius, endRadius);

            mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    mRadius = (float) animation.getAnimatedValue();


                    mView.postInvalidate();
                }
            });


            mValueAnimator.setDuration(1200);
            return  new CRAnimation(mValueAnimator);

        }
    }




    public void draw(Canvas canvas) {
        if (mValueAnimator != null && mValueAnimator.isRunning()) {
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
