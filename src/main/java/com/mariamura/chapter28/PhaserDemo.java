package com.mariamura.chapter28;

import java.util.concurrent.Phaser;

public class PhaserDemo {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(1);
        int curPhase;
        System.out.println("Start threads...");

        new MyThread3(phaser, "a");
        new MyThread3(phaser, "b");
        new MyThread3(phaser, "c");


        curPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase " + curPhase + " is completed");

        curPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase " + curPhase + " is completed");

        curPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase " + curPhase + " is completed");

        phaser.arriveAndDeregister();

        if(phaser.isTerminated()) System.out.println("Phaser is done");


    }
}

class MyThread3 implements Runnable {
    Phaser phaser;
    String name;

    public MyThread3(Phaser phaser, String name) {
        this.phaser = phaser;
        this.name = name;
        phaser.register();
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println(name + " is started phase one");
        phaser.arriveAndAwaitAdvance();

        try {
            Thread.sleep(10);
        }catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println(name + " is started phase two");
        phaser.arriveAndAwaitAdvance();

        try {
            Thread.sleep(10);
        }catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println(name + " is started phase three");
        phaser.arriveAndDeregister();

    }
}
