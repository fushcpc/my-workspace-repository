package com.j2se.vedio;

import java.util.Calendar;

public class MillionYearCalendar {
    private final static String CALENDAR_HEADER = "\t日\t一\t二\t三\t四\t五\t六";

    public static void main(String[] args) {
        printCalendar(2012, 4);
    }

    @SuppressWarnings("deprecation")
    public static void printCalendar(int year, int month) {
        System.out.println("\t\t\t" + year + "年" + month + "月");
        System.out.println(CALENDAR_HEADER);
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, 1);
        System.out.println(cal.get(Calendar.WEEK_OF_MONTH));
        System.out.println(cal.getTime().getYear());
        System.out.println(cal.getTime().getMonth());
    }
}
