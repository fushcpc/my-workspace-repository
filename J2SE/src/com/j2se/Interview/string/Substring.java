package com.j2se.Interview.string;

public class Substring {
    public static void main(String[] args) {
        String str = "what will happen if beginIndex is equal to length in substring(int beginIndex)";
        System.out.println("str.substring(str.length()) :"
                + str.substring(str.length()));
        str = "Same is the case when beginIndex and endIndex is equal, in case of substring second method";
        System.out.println("str.substring(3, 3) :" + str.substring(3, 3));
    }
}
