package com.j2se.book.thinkinginjava.thread;

public class LazySingleDemo {
    private static LazySingleDemo instance = new LazySingleDemo();

    private LazySingleDemo() {
    }

    public static LazySingleDemo getInstance() {
        if (instance == null) {// 此处的代码只为增加性能，尽量少地检查锁
            synchronized (LazySingleDemo.class) {// 静态变量只能以.class来加锁，不能使用this
                if (instance == null) {
                    instance = new LazySingleDemo();
                }
            }
        }
        return instance;
    }
}
