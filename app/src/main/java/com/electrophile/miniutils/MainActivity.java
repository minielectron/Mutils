package com.electrophile.miniutils;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import electrophile.mutils.MiniAnimationUtils;
import electrophile.mutils.MiniDialogUtils;
import electrophile.mutils.MiniValidationUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editText = findViewById(R.id.editText);
        Button checkButton = findViewById(R.id.checkBtn);
        TextInputLayout inputLayout = findViewById(R.id.layout);
        MiniValidationUtils validationUtils = new MiniValidationUtils();
        editText.addTextChangedListener(new MiniValidationUtils.EditTextValidator(editText){
            @Override
            public void validate(TextView text, String str) {
                if(validationUtils.isValidEmail(str)){
                    inputLayout.setError("");
                }else inputLayout.setError("Enter the correct phone number");

            }
        });

        checkButton.setOnClickListener(v -> {
            if(validationUtils.isValidEmail(editText.getText().toString())){
                inputLayout.setError("");
            }else inputLayout.setError("Enter the correct phone number");
        });
//        MiniDialogUtils.createAlertDialog(MainActivity.this,"Test Dialog", "Minielectron is good");
    }
}
