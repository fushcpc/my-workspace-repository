package com.j2se.vedio.shenshiyuan;

/*Java中的每一个对象都有一个锁(Lock)或者叫做监视器(Monitor)，当访问某个对象的synchronized方法时，表示将该对象上锁，此时其它任何线程都无法再去访问该对象所有的synchronized方法了，直到之前的那个线程执行方法完毕后(或者抛出了异常)，那么将该对象的锁释放掉，其它的线程才有可能再去访问该synchronized方法。

 如果一个对象有多个synchronized方法，某一时刻某个线程已经进入了某个synchronized方法，那么在该方法没有执行完毕前，其它线程是无法访问同一个对象的任何synchronized方法的，但不同对象间不会有任何影响

 如果某个synchronized方法是static的，那么当线程访问方法时，它锁的并不是synchronized方法所在的对象，而是synchronized方法所在的对象所对应的class对象，因为Java中无论一个类有多少个对象，这些对象只会对应唯一一个Class对象，因此当线程分别访问同一个类的两个对象的两个static，synchronized方法时，他们执行的顺序也是顺序的，也就是说一个线程先去执行方法，执行完毕后另一个线程才开始执行。如下面的程序
 */
public class SynchronizedTest {
    public static void main(String[] args) {
        Example example = new Example();

        Thread thread1 = new MyThread1(example);

        example = new Example();

        Thread thread2 = new MyThread2(example);

        thread1.start();
        thread2.start();
    }
}

class Example {
    public synchronized static void execute1() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hello:" + i);
        }
    }

    // 如果execute2方法没有static，只有execute1有，
    // 那么执行的顺序还是乱序的
    public synchronized static void execute2() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("world:" + i);
        }
    }
}

@SuppressWarnings("static-access")
class MyThread1 extends Thread {
    private Example example;

    public MyThread1(Example example) {
        this.example = example;
    }

    @Override
    public void run() {
        example.execute1();
    }
}

@SuppressWarnings("static-access")
class MyThread2 extends Thread {
    private Example example;

    public MyThread2(Example example) {
        this.example = example;
    }

    @Override
    public void run() {
        example.execute2();
    }
}
