package com.electrophile.miniutils;

import android.Manifest;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import electrophile.mutils.MiniAnimationUtils;
import electrophile.mutils.MiniPermissionUtils;

public class PermissionsActivity extends AppCompatActivity {

    VideoView videoView ;
    MiniAnimationUtils animationUtils;
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

        videoView = findViewById(R.id.video_view);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.buttons);
        videoView.setVideoURI(uri);
        videoView.setOnPreparedListener(mp ->{
            int videoWidth = mp.getVideoWidth();
            int videoHeight = mp.getVideoHeight();

            //Get VideoView's current width and height
            int videoViewWidth = videoView.getWidth();
            int videoViewHeight = videoView.getHeight();

            float xScale = (float) videoViewWidth / videoWidth;
            float yScale = (float) videoViewHeight / videoHeight;

            //For Center Crop use the Math.max to calculate the scale
            //float scale = Math.max(xScale, yScale);
            //For Center Inside use the Math.min scale.
            //I prefer Center Inside so I am using Math.min
            float scale = Math.min(xScale, yScale);

            float scaledWidth = scale * videoWidth;
            float scaledHeight = scale * videoHeight;

            //Set the new size for the VideoView based on the dimensions of the video
            ViewGroup.LayoutParams layoutParams = videoView.getLayoutParams();
            layoutParams.width = (int)scaledWidth;
            layoutParams.height = (int)scaledHeight;
            videoView.setLayoutParams(layoutParams);
            mp.setLooping(true);

        });
        videoView.setMediaController(new MediaController(this));
        videoView.start();


        //Animation utils usage
        animationUtils = new MiniAnimationUtils(this);
        permissionUtils = new MiniPermissionUtils(this);
        Log.i(TAG, "onCreate: " + permissionUtils.hasAllPermissions(permissions));
        permissionUtils.requestPermission(this, permissionUtils.netPermissionsRemaining(permissions), 90);
        Log.i(TAG, "onCreate: " + permissionUtils.hasAllPermissions(permissions));
//        Slide slide = (Slide) TransitionInflater.from(this).inflateTransition(android.R.transition.slide_right);
//        getWindow().setExitTransition(slide);
//        getWindow().setEnterTransition(slide);
        animationUtils.slideActvityFromLeftToRightExitTransition(this);
    }
//
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        animationUtils.slideActvityFromLeftToRightExitTransition(this);


//        overridePendingTransition(R.anim.slide_enter_from_top,R.anim.slide_exit_to_bottom);
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
