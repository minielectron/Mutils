package com.electrophile.miniutils;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import electrophile.mutils.MiniAnimationUtils;
import electrophile.mutils.MiniDialogUtils;
import electrophile.mutils.MiniKeyInputUtils;
import electrophile.mutils.MiniNetworkingUtils;
import electrophile.mutils.MiniValidationUtils;

public class MainActivity extends AppCompatActivity {

    MiniAnimationUtils animationUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animationUtils = new MiniAnimationUtils(this);
        EditText editText = findViewById(R.id.editText);
        Button checkButton = findViewById(R.id.checkBtn);
        TextInputLayout inputLayout = findViewById(R.id.layout);
        editText.addTextChangedListener(new MiniValidationUtils.EditTextValidator(editText) {
            @Override
            public void validate(TextView text, String str) {
                if (MiniValidationUtils.isValidPhone(str)) {
                    inputLayout.setError("");
                } else inputLayout.setError("Enter the correct phone number");

            }
        });

        ViewGroup viewGroup = findViewById(R.id.root);
//        viewGroup.removeView(checkButton);
        animationUtils.setTransitionChaoticAnimationOnViewGroup(viewGroup);

        //How to hide the soft keyboard using the MiniKeyUtils
        ViewGroup root = findViewById(android.R.id.content);
        MiniKeyInputUtils.hideSoftKeyboarOnTouchOutside(root, this);

        // Demo of how to use the MiniNetworkUtils and DialogUtils
        if (MiniNetworkingUtils.isConnected(this))
            Toast.makeText(this, "Network connected", Toast.LENGTH_SHORT).show();
        else
            MiniDialogUtils.createAlertDialog(MainActivity.this, "Network Connectivity", "Turn on Internet From Settings");


        //This will validate the input and show the animation of size change in button
        checkButton.setOnClickListener(v -> {
            if (MiniValidationUtils.isValidPhone(editText.getText().toString())) {
                inputLayout.setError("");
            } else inputLayout.setError("Enter the correct phone number");
            animationUtils.setTransitionChaoticAnimationOnViewGroup(viewGroup);
            animationUtils.changeSize(checkButton);
            startActivity(new Intent(getApplicationContext(), PermissionsActivity.class));
        });
    }
}
