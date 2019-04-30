package electrophile.mutils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
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
}
