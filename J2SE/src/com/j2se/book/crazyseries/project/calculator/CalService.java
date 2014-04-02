package com.j2se.book.crazyseries.project.calculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.david.swing.utility.StringUtility;

public class CalService {

    static {
        List<String> list = new ArrayList<String>();
        list.add("+");
        list.add("-");
        list.add("/");
        list.add("*");
        opList = Collections.unmodifiableList(list);
    }

    private static final String       NUM_STRING     = "0123456789";
    private static final List<String> opList;
    private static final String       SUM_STRING     = "=";
    private static final String       CLEAR_STRING   = "C";
    private static final String       BACK_STRING    = "Back";
    private static final String       DEFAULT_STRING = "";
    private static boolean            isLastPressOp  = false;
    private static String             firstNum;
    private static String             op;

    public String calMethod(String cmd, String text) {
        if (CLEAR_STRING.equals(cmd)) {
            return DEFAULT_STRING;
        }
        if (BACK_STRING.equals(cmd)) {
            return deleteStr(text);
        }
        if (SUM_STRING.equals(cmd)) {
            String result = sum(cmd, text);
            firstNum = text;
            return result;
        }
        if (opList.contains(cmd)) {
            isLastPressOp = true;
            op = cmd;
            return text;
        }
        if ("sqrt".equals(cmd)) {
            return handleResult(String.valueOf(Math.sqrt(Double.valueOf(text))));
        }
        if ("1/x".equals(cmd)) {
            return handleResult(String.valueOf(1 / Double.valueOf(text)));
        }
        if ("+/-".equals(cmd)) {
            if (StringUtility.isNullOrEmpty(text)) {
                return DEFAULT_STRING;
            }
            if (text.startsWith("-")) {
                return text.substring(1);
            }
            return "-" + text;
        }
        if (".".equals(cmd)) {
            if (!StringUtility.isNullOrEmpty(text)) {
                if (text.indexOf(".") == -1) {
                    return text + ".";
                }
            }
        }
        if (NUM_STRING.indexOf(cmd) != -1) {
            if (isLastPressOp) {
                firstNum = text;
                isLastPressOp = false;
                return cmd;
            }
            return text + cmd;
        }
        return text;
    }

    private String handleResult(String result) {
        if (result.endsWith(".0")) {
            return result.substring(0, result.length() - 2);
        }
        return result;
    }

    private String deleteStr(String text) {
        if (!StringUtility.isNullOrEmpty(text)) {
            return text.substring(0, text.length() - 1);
        }
        return DEFAULT_STRING;
    }

    private String sum(String cmd, String text) {
        if ("+".equals(op)) {
            return add(text);
        }
        if ("-".equals(op)) {
            return subtract(text);
        }
        if ("*".equals(op)) {
            return multipy(text);
        }
        if ("/".equals(op)) {
            return divide(text);
        }
        return "";
    }

    private String multipy(String text) {
        return getBigDecimal(firstNum).multiply((getBigDecimal(text))).toString();
    }

    private String subtract(String text) {
        return getBigDecimal(firstNum).subtract((getBigDecimal(text))).toString();
    }

    private String add(String text) {
        return getBigDecimal(firstNum).add(getBigDecimal(text)).toString();
    }

    private String divide(String text) {
        return getBigDecimal(firstNum).divide(getBigDecimal(text)).toString();
    }

    private BigDecimal getBigDecimal(String value) {
        return new BigDecimal(value);
    }

}
