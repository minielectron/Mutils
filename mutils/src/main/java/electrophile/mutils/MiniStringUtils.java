package electrophile.mutils;

import android.text.TextUtils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class MiniStringUtils {

    public static String getCurrencyFormat(String rupees) {
        if (!TextUtils.isEmpty(rupees)) {
            Locale locale = new Locale("en", "IN");
            DecimalFormat decimalFormat = (DecimalFormat) DecimalFormat.getCurrencyInstance(locale);
            DecimalFormatSymbols dfs = DecimalFormatSymbols.getInstance(locale);
            dfs.setCurrencySymbol("\u20B9");
            decimalFormat.setDecimalFormatSymbols(dfs);
            return decimalFormat.format(Double.valueOf(rupees));
        }else return "\u20B9 00.00";
    }
}
