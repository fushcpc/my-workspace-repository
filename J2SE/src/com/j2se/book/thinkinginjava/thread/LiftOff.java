package com.j2se.book.thinkinginjava.thread;

import java.util.concurrent.TimeUnit;

public class LiftOff implements Runnable {
    private int countDown = 10; // default
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff() {
    }

    public LiftOff(int countDown) {
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
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread liftOffThread = new Thread(new LiftOff());
            liftOffThread.start();
        }
        System.out.println("Waiting for lift off!");
    }

}
