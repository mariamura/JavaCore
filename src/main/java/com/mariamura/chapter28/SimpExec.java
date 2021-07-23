package com.mariamura.chapter28;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpExec {
    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(5);
        CountDownLatch latch2 = new CountDownLatch(5);
        CountDownLatch latch3 = new CountDownLatch(5);
        CountDownLatch latch4 = new CountDownLatch(5);
        ExecutorService es = Executors.newFixedThreadPool(1); //опечатка в книге?

        System.out.println("Start threads..");

        es.execute(new MyThread6( "a", latch));
        es.execute(new MyThread6( "b", latch2));
        es.execute(new MyThread6( "c", latch3));
        es.execute(new MyThread6( "d", latch4));

        try {
            latch.await();
            latch2.await();
            latch3.await();
            latch4.await();
        }catch (InterruptedException e) {
            System.out.println(e);
        }

        es.shutdown();
        System.out.println("Thread terminated...");

    }
}

class MyThread6 implements Runnable {
    String name;
    CountDownLatch latch;

    public MyThread6(String name, CountDownLatch latch) {
        this.name = name;
        this.latch = latch;
        new Thread(this);
    }

    @Override
    public void run() {
        for (int i = 0; i<5; i++) {
            System.out.println(name + " :" + i);
            latch.countDown();
        }
    }
}
