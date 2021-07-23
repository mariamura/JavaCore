package com.mariamura.chapter28;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {
    public static void main(String[] args) {
        new AtomicThread("a");
        new AtomicThread("b");
        new AtomicThread("c");

    }
}

class SharedAt {
    static AtomicInteger ai = new AtomicInteger(0);
}

class AtomicThread implements Runnable {
    String name;
    AtomicThread(String n) {
        name = n;
        new Thread(this).start();
    }
    @Override
    public void run() {
        System.out.println("Start thread: " + name);
        for(int i = 1; i<=3; i++) {
            System.out.println(name + ", ai count got: " + SharedAt.ai.getAndSet(i));
        }
    }
}
