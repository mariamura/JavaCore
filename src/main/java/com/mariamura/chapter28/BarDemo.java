package com.mariamura.chapter28;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class BarDemo {
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(3, new BarAction());

        System.out.println("Ready");

        new MyThread2(cb, "A");
        new MyThread2(cb, "B");
        new MyThread2(cb, "C");

    }
}

class MyThread2 implements Runnable {
    CyclicBarrier cBar;
    String name;

    public MyThread2(CyclicBarrier cBar, String name) {
        this.cBar = cBar;
        this.name = name;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println(name);

        try {
            cBar.await();
        }catch (InterruptedException | BrokenBarrierException e) {
            System.out.println(e);
        }
    }
}

class BarAction implements Runnable {
    public void run() {
        System.out.println("Barrier achieved");
    }
}
