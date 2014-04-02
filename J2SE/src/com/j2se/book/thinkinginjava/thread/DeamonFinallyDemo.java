package com.j2se.book.thinkinginjava.thread;

import java.util.concurrent.TimeUnit;

public class DeamonFinallyDemo {
    public static void main(String[] args) throws InterruptedException {
        launchInNormalWay();
        Thread.sleep(4000);// it will output the finally print
        // out when open this line
    }

    private static void launchInNormalWay() {
        Thread t = new Thread(new DeamonFinallyThread());
        t.setDaemon(true);
        t.start();
    }
}

class DeamonFinallyThread implements Runnable {

    @Override
    public void run() {
        System.out.println("Starting Deamon thread...");
        try {
            System.out.println("before sleep");
            TimeUnit.SECONDS.sleep(10);
            System.out.println("after sleep");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally in DeamonFinallyDemon");// will not
                                                                // output
        }
    }

}