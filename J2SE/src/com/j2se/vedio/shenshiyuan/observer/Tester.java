package com.j2se.vedio.shenshiyuan.observer;

public class Tester {
    public static void main(String[] args) {
        Watched watched = new Watched();

        Watcher1 watcher1 = new Watcher1();
        Watcher2 watcher2 = new Watcher2();

        watched.addObserver(watcher1);
        watched.addObserver(watcher2);

        watched.counter();
    }
}
