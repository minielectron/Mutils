package electrophile.mutils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Interpolator;

public class MiniAnimationUtils {
    private Context context;

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
        final Animation bounce = android.view.animation.AnimationUtils.loadAnimation(context, R.anim.fade_out);
        view.setOnClickListener(view1 -> view1.startAnimation(bounce));
    }

    public void moveAnimation(View view) {
        final Animation bounce = android.view.animation.AnimationUtils.loadAnimation(context, R.anim.move);
        view.setOnClickListener(view1 -> view1.startAnimation(bounce));
    }

    public void rotateAnimation(View view) {
        final Animation bounce = android.view.animation.AnimationUtils.loadAnimation(context, R.anim.rotate);
        view.setOnClickListener(view1 -> view1.startAnimation(bounce));
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
}
