package com.mariamura.chapter11;

class NewThread5 implements Runnable {
    String name;
    Thread t;
    boolean suspendFlag;

    NewThread5(String threadName) {
        name = threadName;
        t = new Thread(this, name);
        System.out.println("New thread: " + t);
        suspendFlag = false;
        t.start();
    }

    @Override
    public void run() {
        try{
            for(int i = 15; i>0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(200);
                synchronized (this) {
                    while (suspendFlag) {
                        wait();
                    }
                }
            }
        }catch (InterruptedException e) {
            System.out.println(name + " interrupted");
        }
        System.out.println(name + " completed");
    }

    synchronized void mySuspend() {
        suspendFlag = true;
    }

    synchronized void myResume() {
        suspendFlag = false;
        notify();
    }
}

public class SuspendResume {
    public static void main(String[] args) {

        NewThread5 ob1 = new NewThread5("One");
        NewThread5 ob2 = new NewThread5("Two");


        try {
            Thread.sleep(1000);
            ob1.mySuspend();
            System.out.println("Thread One paused");
            Thread.sleep(1000);
            ob1.myResume();
            System.out.println("Thread One resumed");
            Thread.sleep(1000);
            ob2.mySuspend();
            System.out.println("Thread Two paused");
            Thread.sleep(1000);
            ob2.myResume();
            System.out.println("Thread Two resumed");
        }catch (InterruptedException e) {
            System.out.println("Main thread interrupted!");
        }

        try {
            System.out.println("Waiting for thread completed");
            ob1.t.join();
            ob2.t.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        System.out.println("Main thread completed");
    }
}
