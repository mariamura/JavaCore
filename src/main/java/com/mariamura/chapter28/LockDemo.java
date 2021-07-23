package com.mariamura.chapter28;

import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        new LockThread("a", lock);
        new LockThread("b", lock);
    }
}

class Shared2 {
    static int count = 0;
}

class LockThread implements Runnable {
    String name;
    ReentrantLock lock;

    public LockThread(String name, ReentrantLock lock) {
        this.name = name;
        this.lock = lock;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Start thread: " + name);

        try {
            System.out.println("Thread " + name + " is waiting for blocking");
            lock.lock();
            System.out.println(name + " blocked");
            Shared2.count++;
            System.out.println("Thread " + name +", count: " + Shared2.count);
            System.out.println(name + " is waiting");
            Thread.sleep(1000);
        }catch (InterruptedException e) {
            System.out.println(e);
        } finally {
            System.out.println(name + " is unblocking lock..");
            lock.unlock();
        }
    }
}
