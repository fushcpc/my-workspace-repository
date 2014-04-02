package com.j2se.test;

public class IntegerTest {
    public static void main(String args[]) {
        Integer counter = 0;
        increaseCounter(counter);
        increaseCounter(counter);
        increaseCounter(counter);
        System.out.println(counter);
    }

    private static void increaseCounter(Integer counter) {
        counter = counter + 1;
        System.out.println(counter);
    }
}