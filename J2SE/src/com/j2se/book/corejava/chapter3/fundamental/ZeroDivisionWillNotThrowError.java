package com.j2se.book.corejava.chapter3.fundamental;

public class ZeroDivisionWillNotThrowError {
    public static void main(String[] args) {
        float f = 2.33f;
        System.out.println(f / 0);// will print "Infinity"
    }
}
