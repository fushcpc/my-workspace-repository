package com.j2se.vedio.shenshiyuan.strategy.impl;

import com.j2se.vedio.shenshiyuan.strategy.Strategy;

public class MulStrategy implements Strategy {

    @Override
    public int caculate(int a, int b) {
        return a * b;
    }

}
