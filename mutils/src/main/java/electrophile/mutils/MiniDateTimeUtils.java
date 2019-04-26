package electrophile.mutils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MiniDateTimeUtils {
    public static String Date(){
        Date currentDateTime = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault());
        return dateFormat.format(currentDateTime);
    }

    public static String Date(String pattern){
        Date currentDateTime = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat(pattern, Locale.getDefault());
        return dateFormat.format(currentDateTime);
    }

    public static String Time(){
        DateFormat timeFormat = SimpleDateFormat.getTimeInstance();
        return timeFormat.format(Calendar.getInstance().getTime());
    }
}
