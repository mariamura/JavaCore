package com.mariamura.chapter28;

import java.util.concurrent.*;

public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(3);
        Future<Integer> fi;
        Future<Double> fd;
        Future<Integer> fi2;

        System.out.println("Start..");

        fi = es.submit(new Sum(10));
        fd = es.submit(new Hypot(3, 4));
        fi2 = es.submit(new Fact(5));

        try {
            System.out.println(fi.get());
            System.out.println(fd.get());
            System.out.println(fi2.get());

        }catch (InterruptedException e) {
            System.out.println(e);
        }catch (ExecutionException e) {
            System.out.println(e);
        }

        es.shutdown();
        System.out.println("Terminated..");
    }
}

class Sum implements Callable<Integer> {
    int stop;

    Sum(int v) {
        stop = v;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for(int i=1;i<stop; i++) sum +=i;
        return sum;
    }
}

class Hypot implements Callable<Double> {
    double side1, side2;

    Hypot(double s1, double s2) {
        side1 = s1;
        side2 = s2;
    }

    @Override
    public Double call() throws Exception {
        return Math.sqrt((side1*side1) + (side2*side2));
    }
}

class Fact implements Callable<Integer> {
    int stop;

    Fact(int v) {
        stop = v;
    }

    @Override
    public Integer call() throws Exception {
        int fact = 1;
        for(int i = 2; i<=stop; i++) {
            fact *=i;
        }
        return fact;
    }
}