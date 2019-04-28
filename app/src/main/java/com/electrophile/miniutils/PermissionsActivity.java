package com.electrophile.miniutils;

import android.Manifest;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import electrophile.mutils.MiniPermissionUtils;

public class PermissionsActivity extends AppCompatActivity {

    private static final String TAG = "PermissionsActivity";
    private String[] permissions = {
            Manifest.permission.READ_CONTACTS,
            Manifest.permission.ACCESS_FINE_LOCATION
    };
    private MiniPermissionUtils permissionUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permissions);

        permissionUtils = new MiniPermissionUtils(this);
        Log.i(TAG, "onCreate: " + permissionUtils.hasAllPermissions(permissions));
        permissionUtils.requestPermission(this, permissionUtils.netPermissionsRemaining(permissions), 90);
        Log.i(TAG, "onCreate: " + permissionUtils.hasAllPermissions(permissions));

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case 90:
                if (permissionUtils.hasAllPermissions(permissions))
                    Toast.makeText(this, "Permissions are accepted", Toast.LENGTH_SHORT).show();
//                else permissionUtils.requestPermission(this,permissionUtils.netPermissionsRemaining(permissions),90);
                break;
        }
    }
}
