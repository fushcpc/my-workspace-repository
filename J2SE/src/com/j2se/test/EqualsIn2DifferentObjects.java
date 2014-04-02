package com.j2se.test;

public class EqualsIn2DifferentObjects {
    public static void main(String[] args) {
        Integer in = new Integer(10);
        Float f = new Float(10.0f);
        System.out.println(in.equals(f));// false
    }
}
