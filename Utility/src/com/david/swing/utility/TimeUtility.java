package com.david.swing.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtility {
    private TimeUtility() {
    }

    public static boolean isValidDateFormat(String dateString, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            Date formatDate = sdf.parse(dateString);
            String afterFormat = sdf.format(formatDate);
            return dateString.equals(afterFormat);
        } catch (ParseException e) {
            return false;
        }
    }
}
