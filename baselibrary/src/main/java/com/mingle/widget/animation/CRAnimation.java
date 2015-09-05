package com.mingle.widget.animation;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.animation.Interpolator;

import com.nineoldandroids.animation.Animator;

/**
 * Created by zzz40500 on 15/9/3.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class CRAnimation {

    private Animator mNAnimator;
    private android.animation.Animator mAAnimator;


    public CRAnimation(Animator NAnimator) {
        mNAnimator = NAnimator;
    }

    public CRAnimation(android.animation.Animator AAnimator) {
        mAAnimator = AAnimator;
    }

    public void setInterpolator(Interpolator interpolator) {

        if (mAAnimator != null) {

            mAAnimator.setInterpolator(interpolator);
        } else if (mNAnimator != null) {

            mNAnimator.setInterpolator(interpolator);
        }

    }

    public void setStartDelay(long startDelay){

        if (mAAnimator != null) {

            mAAnimator.setStartDelay(startDelay);
        } else if (mNAnimator != null) {

            mNAnimator.setStartDelay(startDelay);
        }

    }


    public void addListener(final SimpleAnimListener simpleAnimListener){

        if (mAAnimator != null) {
            mAAnimator.addListener(new android.animation.Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(android.animation.Animator animation) {
                    simpleAnimListener.onAnimationStart(CRAnimation.this);
                }

                @Override
                public void onAnimationEnd(android.animation.Animator animation) {
                    simpleAnimListener.onAnimationEnd(CRAnimation.this);
                }

                @Override
                public void onAnimationCancel(android.animation.Animator animation) {
                    simpleAnimListener.onAnimationCancel(CRAnimation.this);
                }

                @Override
                public void onAnimationRepeat(android.animation.Animator animation) {
                    simpleAnimListener.onAnimationRepeat(CRAnimation.this);
                }
            });
        } else if (mNAnimator != null) {
            mNAnimator.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                    simpleAnimListener.onAnimationStart(CRAnimation.this);
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    simpleAnimListener.onAnimationEnd(CRAnimation.this);
                }

                @Override
                public void onAnimationCancel(Animator animation) {
                    simpleAnimListener.onAnimationCancel(CRAnimation.this);
                }

                @Override
                public void onAnimationRepeat(Animator animation) {
                    simpleAnimListener.onAnimationRepeat(CRAnimation.this);
                }
            });
        }

    }
    public void  end(){
        if (mAAnimator != null) {

            mAAnimator.end();
        } else if (mNAnimator != null) {

            mNAnimator.end();
        }

    }

    public  void cancel(){
        if (mAAnimator != null) {

            mAAnimator.cancel();
        } else if (mNAnimator != null) {

            mNAnimator.cancel();
        }
    }

    public void setDuration(long duration){

        if (mAAnimator != null) {
            mAAnimator.setDuration(duration);
        } else if (mNAnimator != null) {
            mNAnimator.setDuration(duration);
        }

    }


    public void start(){
        if (mAAnimator != null) {

            mAAnimator.start();
        } else if (mNAnimator != null) {

            mNAnimator.start();
        }

    }
}
