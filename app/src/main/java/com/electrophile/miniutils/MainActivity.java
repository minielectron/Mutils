package com.electrophile.miniutils;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import electrophile.mutils.MiniAnimationUtils;
import electrophile.mutils.MiniDialogUtils;
import electrophile.mutils.MiniKeyInputUtils;
import electrophile.mutils.MiniNetworkingUtils;
import electrophile.mutils.MiniValidationUtils;
import electrophile.mutils.components.EditTextDrawableClicker;

public class MainActivity extends AppCompatActivity {

    MiniAnimationUtils animationUtils;
    boolean clicked = false;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animationUtils = new MiniAnimationUtils(this);
        EditText editText = findViewById(R.id.editText);

        /**
         * This is to display the usage of editText validator
         * */
        TextInputLayout inputLayout = findViewById(R.id.layout);
        editText.addTextChangedListener(new MiniValidationUtils.EditTextValidator(editText) {
            @Override
            public void validate(TextView text, String str) {
                if (MiniValidationUtils.isValidPhone(str)) {
                    inputLayout.setError("");
                } else inputLayout.setError("Enter the correct phone number");
            }
        });

        /**
         * This is to display how to use drawable clicker
         */
        EditText editText1 = findViewById(R.id.editText2);
        editText1.setOnTouchListener(new EditTextDrawableClicker(editText1, EditTextDrawableClicker.DRAWABLE_RIGHT) {
            @Override
            public void onClick() {
                editText1.setText("");
            }
        });

        /**
         * This display the animation logic and usage
         * */
        ViewGroup viewGroup = findViewById(R.id.root);
        animationUtils.setTransitionChaoticAnimationOnViewGroup(viewGroup);

        /**
         * How to hide the soft keyboard using the MiniKeyUtils
         * */
        ViewGroup root = findViewById(android.R.id.content);
        MiniKeyInputUtils.hideSoftKeyboarOnTouchOutside(root, this);

        /**
         *  Demo of how to use the MiniNetworkUtils and DialogUtils
         * */
        if (MiniNetworkingUtils.isConnected(this))
            Toast.makeText(
                    this,
                    "Network connected",
                    Toast.LENGTH_SHORT)
                    .show();
        else
            MiniDialogUtils.createAlertDialog(
                    MainActivity.this,
                    "Network Connectivity",
                    "Turn on Internet From Settings");

        findViewById(R.id.more).setOnClickListener(v -> {
            clicked = !clicked;
            TextInputLayout three = findViewById(R.id.layout3);
            TextInputLayout four = findViewById(R.id.layout4);
            if (clicked) {
                three.setVisibility(View.VISIBLE);
                four.setVisibility(View.VISIBLE);
            } else {
                three.setVisibility(View.GONE);
                four.setVisibility(View.GONE);
            }
//            ObjectAnimator animation = ObjectAnimator.ofInt(titleContainer, "maxLines", titleContainer.getHeight());
//            animation.setDuration(1000).start();
        });

//      This will validate the input and show the animation of size change in button

        findViewById(R.id.checkBtn).setOnClickListener(v -> {
            if (MiniValidationUtils.isValidPhone(editText.getText().toString())) {
                inputLayout.setError("");
            } else inputLayout.setError("Enter the correct phone number");
            animationUtils.setTransitionChaoticAnimationOnViewGroup(viewGroup);
//            animationUtils.changeSize(checkButton);
            startActivity(new Intent(getApplicationContext(), PermissionsActivity.class));
        });

//      NOTE:  This animation will work only if you start the activity using , ActivityOptions.makeSceneTransitionAnimation(this).toBundle() as second parameter
//      Fade slide = (Fade) TransitionInflater.from(this).inflateTransition(R.transition.fade_activity);
//      getWindow().setExitTransition(slide);
//      getWindow().setEnterTransition(slide);
//      NOTE : This will work only if the activity is started without ActivityOptions
//        animationUtils.slideActvityFromLeftToRightExitTransition(this);
    }
}
