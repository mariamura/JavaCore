package com.mariamura.chapter11;


class NewThread4 implements Runnable {
    String name;
    Thread t;

    NewThread4(String threadname) {
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

public class DemoJoin {
    public static void main(String[] args) {
        NewThread4 ob1 = new NewThread4("one");
        NewThread4 ob2 = new NewThread4("two");
        NewThread4 ob3 = new NewThread4("three");
        System.out.println("Thread one started: " + ob1.t.isAlive());
        System.out.println("Thread two started: " + ob2.t.isAlive());
        System.out.println("Thread three started: " + ob2.t.isAlive());


        try {
            System.out.println("Waiting for threads");
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        }catch (InterruptedException e) {
            System.out.println("Main thread interrupted!");
        }

        System.out.println("Thread one started: " + ob1.t.isAlive());
        System.out.println("Thread two started: " + ob2.t.isAlive());
        System.out.println("Thread three started: " + ob2.t.isAlive());

        System.out.println("Main thread completed");
    }
}
