package com.j2se.vedio.shenshiyuan.observer;

import java.util.Observable;

public class Watched extends Observable {
    public void counter() {
        for (int i = 0; i < 10; i++) {
            this.setChanged();
            this.notifyObservers(i);
        }
    }
}
