package com.j2se.vedio.shenshiyuan.strategy.env;

import com.j2se.vedio.shenshiyuan.strategy.Strategy;

public class Enviroment {
    private Strategy strategy;

    public Enviroment(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public int caculate(int a, int b) {
        return strategy.caculate(a, b);
    }
}
