package com.david.swing.utility;

import java.util.regex.Pattern;

public class StringUtility {
    public final static String EMPTY_STRING = "";
    // IP regular expression need to update, this is just for temporary use
    private final static String IP_REG_EXPRESSION = "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}";
    private final static Pattern IP_PATTERN = Pattern.compile(IP_REG_EXPRESSION);

    public static boolean isNullOrEmpty(String value) {
        return value == null || EMPTY_STRING.equals(value.trim());
    }

    public static boolean isDigits(String input) {
        if (isNullOrEmpty(input)) {
            return false;
        }
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isIpPattern(String host) {
        return IP_PATTERN.matcher(host).matches();
    }

    public static void main(String[] args) {
        System.out.println(isIpPattern("127.0.0.1"));
    }
}
