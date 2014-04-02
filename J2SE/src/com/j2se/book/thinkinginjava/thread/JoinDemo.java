package com.j2se.book.thinkinginjava.thread;

public class JoinDemo {
    public static void main(String[] args) {
        Sleeper sleepy = new Sleeper("sleepy", 1500);
        Sleeper grumpy = new Sleeper("grumpy", 1500);
        new Joiner("Dopey", sleepy);
        new Joiner("Doc", grumpy);
        grumpy.interrupt();
    }
}

class Sleeper extends Thread {
    private int sleepTime;

    public Sleeper(String threadName, int sleepTime) {
        super(threadName);
        this.sleepTime = sleepTime;
        start();// start thread
    }

    @Override
    public void run() {
        try {
            sleep(sleepTime);
        } catch (InterruptedException e) {
            System.out.println(getName() + " was interrupted. "
                    + "isInterrupted(): " + isInterrupted());
        }
        System.out.println(getName() + " has awakened");
    }
}

class Joiner extends Thread {
    private Sleeper sleeper;

    public Joiner(String threadName, Sleeper sleeper) {
        super(threadName);
        this.sleeper = sleeper;
        start();// start thread
    }

    @Override
    public void run() {
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            System.out.println("interrupted!");
        }
        System.out.println(getName() + " join completed");
    }

}