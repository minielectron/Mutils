package electrophile.mutils.components;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class ThemeUtils {
    private static int sTheme;
    public final static int THEME_DEFAULT = 0;
    public final static int THEME_DARK = 1;
    /**
     * Set the theme of the Activity, and restart it by creating a new Activity of the same type.
     */
    public static void changeToTheme(final AppCompatActivity activity, int theme) {
        sTheme = theme;
        ThemeUtils.changeToTheme(activity, theme);
        activity.recreate();
    }

    /**
     * Set the theme of the activity, according to the configuration.
     */

    public static void onActivityCreateSetTheme(AppCompatActivity activity) {
//        switch (sTheme) {
//            case THEME_DEFAULT:
//                activity.setTheme(R.style.AppTheme);
//                break;
//            case THEME_DARK:
//                activity.setTheme(R.style.DARK_THEME);
//                break;
//            default:
//                activity.setTheme(R.style.AppTheme);
//        }

        //modify the file according to the need of your application
    }
}