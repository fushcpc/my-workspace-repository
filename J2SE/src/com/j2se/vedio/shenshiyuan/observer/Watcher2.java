package com.j2se.vedio.shenshiyuan.observer;

import java.util.Observable;
import java.util.Observer;

public class Watcher2 implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        int countVal = Integer.parseInt(arg.toString());
        if (countVal >= 5) {
            System.out.println("Watcher2 is counting :" + countVal);
        }
    }

}
