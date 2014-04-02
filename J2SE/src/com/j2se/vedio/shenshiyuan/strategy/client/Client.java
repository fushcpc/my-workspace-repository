package com.j2se.vedio.shenshiyuan.strategy.client;

import com.j2se.vedio.shenshiyuan.strategy.env.Enviroment;
import com.j2se.vedio.shenshiyuan.strategy.impl.AddStrategy;
import com.j2se.vedio.shenshiyuan.strategy.impl.MulStrategy;

public class Client {
    public static void main(String[] args) {
        Enviroment env = new Enviroment(new AddStrategy());
        System.out.println(env.caculate(3, 4));

        env.setStrategy(new MulStrategy());
        System.out.println(env.caculate(3, 4));
    }
}
