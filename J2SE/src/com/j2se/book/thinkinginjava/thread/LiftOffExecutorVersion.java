package com.j2se.book.thinkinginjava.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LiftOffExecutorVersion implements Runnable {
    private int countDown = 10; //default
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOffExecutorVersion() {
    }

    public LiftOffExecutorVersion(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff!")
                + "), ";
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.println(status());
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();//优先使用
        //ExecutorService exec = Executors.newFixedThreadPool(5);
        //ExecutorService exec = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOffExecutorVersion());
        }
        exec.shutdown();
        System.out.println("Waiting for lift off!");
    }

}
