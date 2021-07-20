package com.mariamura.chapter28;

import java.util.concurrent.Semaphore;

public class SemDemo {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1);

        new IncThread(sem, "A");
        new DecThread(sem, "B");
    }
}

class Shared {
    static int count = 0;
}

class IncThread implements Runnable {

    String name;
    Semaphore sem;
    IncThread(Semaphore s, String n) {
        sem = s;
        name = n;
        new Thread(this).start();
    }


    @Override
    public void run() {
        System.out.println("Start thread " + name);
        try {
            System.out.println("Thread " + name + " waiting for accept");
            sem.acquire();
            System.out.println("Thread " + name + " get accept");
            for(int i=0; i<5; i++) {
                Shared.count++;
                System.out.println(name + ": " + Shared.count);
                Thread.sleep(10);
            }
        }catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("Thread " + name + " release accept");
        sem.release();
    }
}


class DecThread implements Runnable {

    String name;
    Semaphore sem;
    DecThread(Semaphore s, String n) {
        sem = s;
        name = n;
        new Thread(this).start();
    }


    @Override
    public void run() {
        System.out.println("Start thread " + name);
        try {
            System.out.println("Thread " + name + " waiting for accept");
            sem.acquire();
            System.out.println("Thread " + name + " get accept");
            for(int i=0; i<5; i++) {
                Shared.count--;
                System.out.println(name + ": " + Shared.count);
                Thread.sleep(10);
            }
        }catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("Thread " + name + " release accept");
        sem.release();
    }
}
