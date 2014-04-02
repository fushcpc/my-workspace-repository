package com.j2se.vedio.shenshiyuan.innerclass;

import com.j2se.vedio.shenshiyuan.innerclass.Outer.Inner;

class Outer {
    private static int i = 2;

    public static class Inner {// There can be more than one public class in one
                               // java file.
        public void doSomething() {
            System.out.println(i);
        }
    }
}

public class StaticInnerClassTest {
    public static void main(String[] args) {
        Inner inner = new Outer.Inner();
        inner.doSomething();
    }
}
