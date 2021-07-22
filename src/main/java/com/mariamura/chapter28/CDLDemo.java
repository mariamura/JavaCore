package com.mariamura.chapter28;

import java.util.concurrent.CountDownLatch;

public class CDLDemo {
    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(5);
        System.out.println("Start thread");

        


        new MyThread(cdl);
        try {
            cdl.await();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("Thread terminated");
    }
}

class MyThread implements Runnable {
    CountDownLatch latch;

    public MyThread(CountDownLatch cdl) {
        this.latch = cdl;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for(int i = 0; i<5; i++) {
            System.out.println(i);
            latch.countDown();
        }
    }
}
