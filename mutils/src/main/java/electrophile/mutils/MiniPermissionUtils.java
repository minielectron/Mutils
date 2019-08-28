package electrophile.mutils;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;

/**
 * Copyright 2019 Prakash Sharma
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE
 * AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES
 * OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

/**
 * This class provides the basic permission utilities
 *
 * @author prakash009Kp@gmail.com
 */

public class MiniPermissionUtils {
    private Context context;

    public MiniPermissionUtils(Context context) {
        this.context = context;
    }

    public boolean hasPermission(String permission) {
        return ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED;
    }

    public boolean hasAllPermissions(String[] perms) {
        for (String perm : perms) {
            if (!hasPermission(perm)) {
                return (false);
            }
        }
        return (true);
    }

    public String[] netPermissionsRemaining(String[] wanted) {
        ArrayList<String> result = new ArrayList<>();
        for (String perm : wanted) {
            if (!hasPermission(perm)) {
                result.add(perm);
            }
        }
        return (result.toArray(new String[result.size()]));
    }

    /**
     * This method will request the permission provided that the permissions are already added in the manifest
     *
     * @param activity    : Takes activity for older api permission request, in new request permission for 6.0+ it s not required
     * @param permissions : this is string of permissions
     * @param requestCode : provide unique request code
     */

    public void requestPermission(Activity activity, final String[] permissions, final int requestCode) {
        if (permissions.length != 0)
            ActivityCompat.requestPermissions(activity, permissions, requestCode);
    }

    public void onRequestResult(){
//        if (requestCode == PHONE_STATE_REQUEST_CODE) {
//            setProgress(false);
//            if (grantResults.length > 0
//                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                getIemiNumber();
//            } else if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
//                // Should we show an explanation?
//                if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.READ_PHONE_STATE)) {
//
//                    showRationaleDialog();
//                    //Show permission explanation dialog...
//                } else {
//                    //Never ask again selected, or device policy prohibits the app from having that permission.
//                    //So, disable that feature, or fall back to another situation...
//                    showRationaleDialog();
//                }
//            }
    }

    private void showRationaleDialog() {
//        AlertDialog dialog = new AlertDialog.Builder(getContext())
////                            .setTitle("Permission")
//                .setMessage("Allow to read IMEI number to use the application")
//
//                // Specifying a listener allows you to take an action before dismissing the dialog.
//                // The dialog is automatically dismissed when a dialog button is clicked.
//                .setPositiveButton("Allow", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//                        // Continue with delete operation
//                        Intent intent = new Intent();
//                        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
//                        Uri uri = Uri.fromParts("package", getContext().getPackageName(), null);
//                        intent.setData(uri);
//                        startActivity(intent);
//                    }
//                })
//                // A null listener allows the button to dismiss the dialog and take no further action.
//                .setNegativeButton("Deny", null)
////                            .setIcon(R.drawable.call_top_layer)
//                .create();
//        dialog.setOnShowListener(arg0 -> {
//            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTypeface(Typeface.DEFAULT_BOLD);
//            dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTypeface(Typeface.DEFAULT);
//        });
//        dialog.show();
    }

}
