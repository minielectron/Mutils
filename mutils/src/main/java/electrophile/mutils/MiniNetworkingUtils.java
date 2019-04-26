package electrophile.mutils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class MiniNetworkingUtils {
    private Context context;

    public MiniNetworkingUtils(Context context) {
        this.context = context;
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();

    }
}
