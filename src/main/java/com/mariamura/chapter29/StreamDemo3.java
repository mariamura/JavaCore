package com.mariamura.chapter29;

import java.util.ArrayList;

public class StreamDemo3 {
    public static void main(String[] args) {
        ArrayList<Double> l = new ArrayList<>();
        l.add(7.0);
        l.add(18.0);
        l.add(10.0);
        l.add(24.0);
        l.add(17.0);
        l.add(5.0);
        System.out.println(l);

        double strD = l.parallelStream().reduce(
                1.0,
                (a, b) -> a*Math.sqrt(b),
                (a, b) -> a*b
                );
        System.out.println(strD);
    }
}
