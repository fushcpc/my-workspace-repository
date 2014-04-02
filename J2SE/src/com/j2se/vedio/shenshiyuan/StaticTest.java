package com.j2se.vedio.shenshiyuan;

public class StaticTest {
    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        M n = new N();
        n.output();
    }
}

class M {
    public static void output() {
        System.out.println("from M");
    }
}

class N extends M {
    public static void output() {
        System.out.println("from N");
    }
}