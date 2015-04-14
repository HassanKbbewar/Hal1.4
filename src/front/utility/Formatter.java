package front.utility;

import java.awt.font.NumericShaper;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Hassan
 */
public class Formatter {

    public static String formatDate(Date date) {
        String result;
        SimpleDateFormat myDateFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        result = myDateFormatter.format(date);
        return result.replace('-', '/');
    }

    public static String formatString(String str) {
        NumericShaper shaper = NumericShaper.getShaper(NumericShaper.ARABIC);
        char[] text = str.toCharArray();
        shaper.shape(text, 0, text.length);
        return String.valueOf(text);
    }
}
