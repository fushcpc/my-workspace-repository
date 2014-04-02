package com.j2se.test;

public class NullPointerTestForPrimitiveType {
    private int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        NullPointerTestForPrimitiveType test = new NullPointerTestForPrimitiveType();
        IntegerTest b = null;
        //        test.setA(b); compile error
    }
}
