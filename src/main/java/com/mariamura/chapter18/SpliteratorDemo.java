package com.mariamura.chapter18;

import java.util.ArrayList;
import java.util.Spliterator;

public class SpliteratorDemo {
    public static void main(String[] args) {

        ArrayList<Double> vals = new ArrayList<>();

        for (double i=1.0;i<=5.0; i++) vals.add(i);

        System.out.print("vals content:\n");

        Spliterator<Double> spltitr = vals.spliterator();
        while (spltitr.tryAdvance((n) -> System.out.println(n)));
        System.out.println();

        spltitr = vals.spliterator();
        ArrayList<Double> sqrs = new ArrayList<>();
        while(spltitr.tryAdvance((n) -> sqrs.add(Math.sqrt(n))));

        System.out.print("sqrs content:\n");

        spltitr = sqrs.spliterator();
        spltitr.forEachRemaining((n)->System.out.println(n));
    }
}
