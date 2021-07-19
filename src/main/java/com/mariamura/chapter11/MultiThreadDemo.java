package com.mariamura.chapter11;


class NewThread3 implements Runnable {
    String name;
    Thread t;

    NewThread3(String threadname) {
        name = threadname;
        t = new Thread(this, "Demonstrate thread");
        System.out.println(t);
        t.start();
    }

    @Override
    public void run() {
        try {
            for(int i =5; i>0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e) {
            System.out.println(name + " interrupted!");
        }
        System.out.println(name + " completed");
    }
}

public class MultiThreadDemo {
    public static void main(String[] args) {
        new NewThread3("one");
        new NewThread3("two");
        new NewThread3("three");

        try {
            Thread.sleep(10000);
        }catch (InterruptedException e) {
            System.out.println("Main thread interrupted!");
        }
        System.out.println("Main thread completed");
    }
}
