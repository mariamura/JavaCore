package com.mariamura.chapter28;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

class Transform extends RecursiveAction {
    int seqTr;
    double[] data;
    int start, end;

    public Transform(int seqTr, double[] data, int start, int end) {
        this.seqTr = seqTr;
        this.data = data;
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if((end-start)<seqTr) {
            for(int i = start; i<end; i++) {
                if((data[i]%2)==0) data[i] = Math.sqrt(data[i]);
                else {
                    data[i] = Math.cbrt(data[i]);
                }
            }
        } else {
            int middle = (start+end)/2;
            invokeAll(new Transform(seqTr, data, start, middle),
                    new Transform(seqTr, data, start, end));
        }
    }
}

public class FJExperiment {
    public static void main(String[] args) {
        int pLevel;
        int threshold;

        if(args.length!=2) {
            System.out.println("Use: FJEx parallel threshold");
            return;
        }

        pLevel = Integer.parseInt(args[0]);
        threshold = Integer.parseInt(args[0]);

        long beg, end;

        ForkJoinPool  forkJoinPool = new ForkJoinPool(pLevel);

        double[] nums = new double[100000];

        for(int i = 0; i<nums.length; i++) {
            nums[i] = i;
        }

        beg = System.nanoTime();

        Transform task = new Transform(threshold, nums, 0, nums.length);
        forkJoinPool.invoke(task);

        end = System.nanoTime();

        System.out.println(pLevel + " pl level");
        System.out.println(threshold + " threshold");
        System.out.println((end-beg) + " time");

    }
}
