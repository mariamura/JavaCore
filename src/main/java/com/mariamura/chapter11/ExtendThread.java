package com.mariamura.chapter11;

class NewThread2 extends Thread {
    Thread t;

    NewThread2() {
        t = new Thread(this, "Demonstrate thread");
        System.out.println(t);
        t.start();
    }

    @Override
    public void run() {
        try {
            for(int i =5; i>0; i--) {
                System.out.println("Subsidiary thread: " + i);
                Thread.sleep(500);
            }
        }catch (InterruptedException e) {
            System.out.println("Subsidiary thread interrupted!");
        }
        System.out.println("Subsidiary thread completed");
    }
}

public class ExtendThread {
    public static void main(String[] args) {
        new NewThread2();
        try {
            for(int i =5; i>0; i--) {
                System.out.println("Main thread: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted!");
        }
        System.out.println("Main thread completed");
    }
}
