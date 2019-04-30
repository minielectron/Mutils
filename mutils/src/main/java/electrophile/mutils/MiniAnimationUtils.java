package electrophile.mutils;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

import java.util.Random;

/**
 * Copyright 2019 Prakash Sharma
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE
 * AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES
 * OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */


/**
 * This class provides the basic animation utils for activity's view and viewGroups
 */

public class MiniAnimationUtils {
    private Context context;
    public static final float LARGE_SCALE = 1.5f;
    private boolean symmetric = true;
    private boolean small = true;

    public MiniAnimationUtils(Context context) {
        this.context = context;
    }

    public void scaleAnimation(View view) {
        final Animation scale = android.view.animation.AnimationUtils.loadAnimation(context, R.anim.scale_animation);
        view.setOnClickListener(view1 -> view1.startAnimation(scale));
    }

    public void blinkAnimation(View view) {
        final Animation blink = android.view.animation.AnimationUtils.loadAnimation(context, R.anim.blink);
        view.setOnClickListener(view1 -> view1.startAnimation(blink));
    }

    public void bounceAnimation(View view) {
        final Animation bounce = android.view.animation.AnimationUtils.loadAnimation(context, R.anim.bounce);
        view.setOnClickListener(view1 -> view1.startAnimation(bounce));
    }

    public void fadeInAnimation(View view) {
        final Animation fade_in = android.view.animation.AnimationUtils.loadAnimation(context, R.anim.fade_in);
        view.setOnClickListener(view1 -> view1.startAnimation(fade_in));
    }

    public void fadeOutAnimation(View view) {
        final Animation fade_out = android.view.animation.AnimationUtils.loadAnimation(context, R.anim.fade_out);
        view.setOnClickListener(view1 -> view1.startAnimation(fade_out));
    }

    public void moveAnimation(View view) {
        final Animation move = android.view.animation.AnimationUtils.loadAnimation(context, R.anim.move);
        view.setOnClickListener(view1 -> view1.startAnimation(move));
    }

    public void rotateAnimation(View view) {
        final Animation rotate = android.view.animation.AnimationUtils.loadAnimation(context, R.anim.rotate);
        view.setOnClickListener(view1 -> view1.startAnimation(rotate));
    }

    public void setTransitionYAnimationOnViewGroup(ViewGroup root) {
        int count = root.getChildCount();
        float offset = context.getResources().getDimensionPixelSize(R.dimen.offset_y);
        Interpolator interpolator =
                android.view.animation.AnimationUtils.loadInterpolator(context, android.R.interpolator.linear_out_slow_in);
        // loop over the children setting an increasing translation y but the same animation
        // duration + interpolation
        for (int i = 0; i < count; i++) {
            View view = root.getChildAt(i);
            view.setVisibility(View.VISIBLE);
            view.setTranslationY(offset);
            view.setAlpha(0.67f);
            // then animate back to natural position
            view.animate()
                    .translationY(0f)
                    .alpha(1f)
                    .setInterpolator(interpolator)
                    .setDuration(400L)
                    .start();
            // increase the offset distance for the next view
            offset *= 1.5f;
        }
    }

    public void setTransitionXAnimationOnViewGroup(ViewGroup root) {
        int count = root.getChildCount();
        float offset = context.getResources().getDimensionPixelSize(R.dimen.offset_y);
        Interpolator interpolator =
                android.view.animation.AnimationUtils.loadInterpolator(context, android.R.interpolator.linear_out_slow_in);
        // loop over the children setting an increasing translation y but the same animation
        // duration + interpolation
        for (int i = 0; i < count; i++) {
            View view = root.getChildAt(i);
            view.setVisibility(View.VISIBLE);
            view.setTranslationX(offset);
            view.setAlpha(0.65f);
            // then animate back to natural position
            view.animate()
                    .translationX(0f)
                    .alpha(1f)
                    .setInterpolator(interpolator)
                    .setDuration(400L)
                    .start();
            // increase the offset distance for the next view
            offset *= 1.5f;
        }
    }

    public void setTransitionChaoticAnimationOnViewGroup(ViewGroup viewGroup){
        float maxWidthOffset = 2f * context.getResources().getDisplayMetrics().widthPixels;
        float maxHeightOffset = 2f * context.getResources().getDisplayMetrics().heightPixels;
        Interpolator interpolator =
                AnimationUtils.loadInterpolator(context, android.R.interpolator.linear_out_slow_in);
        Random random = new Random();
        int count = viewGroup.getChildCount();
        for (int i = 0; i < count; i++) {
            View view = viewGroup.getChildAt(i);
            view.setVisibility(View.VISIBLE);
            view.setAlpha(0.85f);
            float xOffset = random.nextFloat() * maxWidthOffset;
            if (random.nextBoolean()) {
                xOffset *= -1;
            }
            view.setTranslationX(xOffset);
            float yOffset = random.nextFloat() * maxHeightOffset;
            if (random.nextBoolean()) {
                yOffset *= -1;
            }
            view.setTranslationY(yOffset);

            // now animate them back into their natural position
            view.animate()
                    .translationY(0f)
                    .translationX(0f)
                    .alpha(1f)
                    .setInterpolator(interpolator)
                    .setDuration(1000)
                    .start();
        }
    }

    public void changeSize(View view) {
        Interpolator interpolator = AnimationUtils.loadInterpolator(context, android.R
                .interpolator.fast_out_slow_in);
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(view, View.SCALE_X, (small ? LARGE_SCALE : 1f));
        scaleX.setInterpolator(interpolator);
        scaleX.setDuration(symmetric ? 600L : 200L);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(view, View.SCALE_Y, (small ? LARGE_SCALE : 1f));
        scaleY.setInterpolator(interpolator);
        scaleY.setDuration(600L);
        scaleX.start();
        scaleY.start();

        // toggle the state so that we switch between large/small and symmetric/asymmetric
        small = !small;
        if (small) {
            symmetric = !symmetric;
        }
    }

    public void slideActvityFromTopToBottomExitTransition(Activity activity){
        activity.overridePendingTransition(R.anim.slide_enter_from_top,R.anim.slide_exit_to_bottom);
    }

    public void slideActvityFromBottomToTopExitTransition(Activity activity){
        activity.overridePendingTransition(R.anim.slide_enter_from_bottom,R.anim.slide_exit_to_top);
    }
    public void slideActvityFromLeftToRightExitTransition(Activity activity){
        activity.overridePendingTransition(R.anim.slide_enter_from_left,R.anim.slide_exit_from_right);
    }

    public void slideActvityFromRightToLeftExitTransition(Activity activity){
        activity.overridePendingTransition(R.anim.slide_enter_from_right,R.anim.slide_exit_from_left);
    }

}
