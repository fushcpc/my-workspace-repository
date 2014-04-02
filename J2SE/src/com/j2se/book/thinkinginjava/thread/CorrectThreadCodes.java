package com.j2se.book.thinkinginjava.thread;

import java.util.concurrent.TimeUnit;

/*
 * 这个程序的所有输出都是为"from flag = false"，这是因为虽然有code1处将flag置为false,
 * 但主线程在thread1还没有启动完的时候就已经执行了code1部分的代码，从而有这样的输出。
 * 可以在code1前面加个sleep就可以达到所要的目的了
 */
public class CorrectThreadCodes {
    public static void main(String[] args) throws InterruptedException {
        ThreadDemo t = new ThreadDemo();
        Thread thread1 = new Thread(t);
        thread1.start();
        // TimeUnit.SECONDS.sleep(1);
        // System.out.println("sleep over in main()");
        t.flag = false;// code1
        Thread thread2 = new Thread(t);
        thread2.start();
    }
}

class ThreadDemo implements Runnable {
    boolean flag = true;

    @Override
    public void run() {
        if (flag) {
            while (true) {
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("from flag = true");
            }
        } else {
            while (true) {
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("from flag = false");
            }
        }
    }

}