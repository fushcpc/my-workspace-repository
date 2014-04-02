package com.j2se.book.thinkinginjava.thread.synchronize;

public class EventGenerator extends IntGenerator {
    private int currentVal = 0;

    /**
     * this method will generate even number only,
     * but it only output two line before it ends in main method,
     * it means that, the resource competition happen in the currentVal
     */
    @Override
    public synchronized int next() {
        ++currentVal;
//        Thread.yield(); 
        ++currentVal;
        return currentVal;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EventGenerator());
    }

}
