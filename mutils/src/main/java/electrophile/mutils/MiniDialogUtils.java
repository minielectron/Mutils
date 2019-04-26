package electrophile.mutils;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;

public class MiniDialogUtils {

    private static AlertDialog alertDialog =  null;
    /*
    * @param Context provide as Activity.this
    * @return none
    * */

    public static void createAlertDialog(final Context context,String title,String message) {

        if (alertDialog != null && alertDialog.isShowing()) return;
        alertDialog = new AlertDialog.Builder(context)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("Yes", (dialogInterface, i) -> {
                    Intent intent = new Intent(Settings.ACTION_DATA_ROAMING_SETTINGS);
                    ComponentName cName = new ComponentName("com.android.phone", "com.android.phone.Settings");
                    intent.setComponent(cName);
                    context.startActivity(intent);
                })
                //set negative button
                .setNegativeButton("Exit", (dialogInterface, i) -> alertDialog.cancel())
                .create();

        alertDialog.show();
        alertDialog.setCancelable(false);
        alertDialog.setCanceledOnTouchOutside(false);
    }
}
