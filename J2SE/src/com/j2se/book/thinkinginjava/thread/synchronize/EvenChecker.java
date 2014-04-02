package com.j2se.book.thinkinginjava.thread.synchronize;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenChecker implements Runnable {

    private IntGenerator generator;
    @SuppressWarnings("unused")
    private final int id;

    public EvenChecker(IntGenerator generator, int ident) {
        this.generator = generator;
        this.id = ident;
    }

    @Override
    public void run() {
        while (!generator.isCancel()) {
            int val = generator.next();
            if (val % 2 != 0) {
                System.out.println(val + " not even!");
                generator.cancel();
            }
        }
    }

    public static void test(IntGenerator gp, int count) {
        System.out.println("Press control-c to exit");
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            exec.execute(new EvenChecker(gp, i));
        }
        exec.shutdown();
    }

    public static void test(IntGenerator gp) {
        test(gp, 10);
    }

}
