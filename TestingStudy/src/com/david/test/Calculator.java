package com.david.test;

public class Calculator {
    public int devide(int a, int b) throws Exception {
        if (b == 0) {
            throw new Exception("除数不能为0！");
        }
        return a / b;
    }
}
