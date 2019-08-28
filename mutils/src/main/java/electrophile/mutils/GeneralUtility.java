package electrophile.mutils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class GeneralUtility {

    private GeneralUtility() {
        throw new AssertionError();
    }

    private static final String TAG = "GeneralUtility";
    public static ArrayList<Integer> currentConsecutiveDateList = new ArrayList<>();
    private static MiniPermissionUtils permissionUtils;
    private static int CALL_PERMISSION_CODE = 100;
    static boolean isProgressBarShowing = false;


    public static void makeActivityFullScreen(Window window) {
        if (window == null) {
            Log.d(TAG, "makeActivityFullScreen: Window object is null");
            return;
        }
        View decorView = window.getDecorView();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            window.getAttributes().layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
        }
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        );
    }

    public static int getTodayDate() {
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat currentDateSDFFormat = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);
        String current_date_string = currentDateSDFFormat.format(date);
        Log.i("Error", "getTodayDate: " + current_date_string);
        return Integer.parseInt(current_date_string);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String formatDate(String dateStr) throws ParseException {
        if (dateStr == null) {
            Log.d(TAG, "formatDate: Date String is null");
            return "";
        }
        String format = "dd MMM, yyyy";
        if (Build.VERSION.SDK_INT >= 26) {
            TemporalAccessor temporal = DateTimeFormatter
                    .ofPattern("yyyy-MM-dd HH:mm:ss.S")
                    .parse(dateStr); // use parse(date, LocalDateTime::from) to get LocalDateTime
            return DateTimeFormatter.ofPattern(format).format(temporal);
        } else {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S", Locale.ENGLISH);
            SimpleDateFormat simpleDateStr = new SimpleDateFormat(format, Locale.ENGLISH);
            return simpleDateStr.format(simpleDateFormat.parse(dateStr));
        }

    }

    public static void callTo(String number, Context context, Activity activity) {
        permissionUtils = new MiniPermissionUtils(context);
        if (number == null) {
            Toast.makeText(context, "The number is not valid!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (permissionUtils.hasPermission(Manifest.permission.CALL_PHONE)) {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + number));
            context.startActivity(callIntent);
        } else {
            permissionUtils.requestPermission(activity, new String[]{Manifest.permission.CALL_PHONE}, CALL_PERMISSION_CODE);
        }
    }

    public static boolean isPackageInstalled(Context c, String targetPackage) {
        PackageManager pm = c.getPackageManager();
        try {
            PackageInfo info = pm.getPackageInfo(targetPackage, PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
        return true;
    }


    public static void showProgressBar(View maskFrame, DrawerLayout drawerLayout) {
        if (maskFrame != null && drawerLayout != null) {
            isProgressBarShowing = true;
            maskFrame.setVisibility(View.VISIBLE);
            lockDrawer(drawerLayout);
        } else Log.d(TAG, "hideProgressBar: view is null");

    }

    /*<FrameLayout
            android:background="@color/white"
            android:clickable="false"
            android:alpha="0.4"
            android:visibility="visible"
            android:id="@+id/mask_frame"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:focusable="true">
            <ProgressBar
                android:layout_gravity="center"
                android:id="@+id/progress_bar"
                android:layout_width="48dp"
                android:layout_height="48dp"
                android:visibility="visible"
                android:foregroundTint="@color/Blue"
                android:indeterminateDrawable="@drawable/custom_progressbar"/>
        </FrameLayout>*/

    //Apply the maskFrame in FrameLayout above you layout

    public void hideProgressBar(View maskFrame, DrawerLayout drawerLayout) {
        if (maskFrame != null && drawerLayout != null) {
            isProgressBarShowing = false;
            maskFrame.setVisibility(View.GONE);
            unlockDrawer(drawerLayout);
        } else Log.d(TAG, "hideProgressBar: view is null");
    }

    private static void lockDrawer(@NonNull DrawerLayout drawerLayout) {
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
    }

    private void unlockDrawer(@NonNull DrawerLayout drawerLayout) {
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
    }


}
