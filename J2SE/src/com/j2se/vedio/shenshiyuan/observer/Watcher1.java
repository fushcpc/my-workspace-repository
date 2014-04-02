package com.j2se.vedio.shenshiyuan.observer;

import java.util.Observable;
import java.util.Observer;

public class Watcher1 implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Watcher1 is counting :" + arg);
    }

}
