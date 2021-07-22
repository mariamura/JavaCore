package com.mariamura.chapter28;

import java.util.concurrent.Phaser;

public class PhaserDemo2 {
    public static void main(String[] args) {
        MyPhaser myPhaser = new MyPhaser(1, 4);
        System.out.println("Start threads..");

        new MyThread4(myPhaser, "a");
        new MyThread4(myPhaser, "b");
        new MyThread4(myPhaser, "c");

        while(!myPhaser.isTerminated()) {
            myPhaser.arriveAndAwaitAdvance();
        }

        System.out.println("Phaser is done");
    }
}

class MyPhaser extends Phaser {
    int numPhase;

    public MyPhaser(int parties, int phaseCount) {
        super(parties);
        numPhase = phaseCount -1;
    }

    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        System.out.println("Phase " + phase + " completed");

        if(phase==numPhase||registeredParties==0) return true;
        return false;
    }
}

class MyThread4 implements Runnable {

    Phaser phaser;
    String name;

    public MyThread4(Phaser phaser, String name) {
        this.phaser = phaser;
        this.name = name;
        phaser.register();
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (!phaser.isTerminated()) {
            System.out.println(name + " is start phase " + phaser.getPhase());
            phaser.arriveAndAwaitAdvance();

            try {
                Thread.sleep(10);
            }catch (InterruptedException e) {
                System.out.println(e);
            }
        }

    }
}
