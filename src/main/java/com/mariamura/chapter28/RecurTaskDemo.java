package com.mariamura.chapter28;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

///stackOverFlow
class Sum1 extends RecursiveTask<Double> {
    final int seqTr = 500;

    double[] data;

    int start, end;

    public Sum1(double[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Double compute() {
        double sum = 0;

        if((end-start)<seqTr) {
            for(int i = start; i<end; i++) {
                sum = sum + data[i];
            }
        } else {
            int middle = (start+end)/2;
            Sum1 subTaskA = new Sum1(data, start,middle);
            Sum1 subTaskB = new Sum1(data, start,end);
            subTaskA.fork();
            subTaskB.fork();
            sum = subTaskA.join() + subTaskB.join();
        }
        return sum;
    }
}

public class RecurTaskDemo {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        double[] nums = new double[5000];

        for (int i = 0; i<nums.length; i++) {
            nums[i] = (((i%2)==0)?i:-i);
        }

        Sum1 task = new Sum1(nums, 0, nums.length);
        double summation = forkJoinPool.invoke(task);

        System.out.println(summation);
    }
}
