package com.mariamura.chapter29;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.stream.Stream;

public class StreamDemo10 {
    public static void main(String[] args) {
        ArrayList<String> l = new ArrayList<>();
        l.add("Alpha");
        l.add("Beta");
        l.add("Gamma");
        l.add("Delta");
        l.add("Qsi");
        l.add("Omega");

        Stream<String> stream = l.stream();
        Spliterator<String> itr = stream.spliterator();
        Spliterator<String> itr2 = itr.trySplit();
        if(itr2 != null) {
            itr2.forEachRemaining(n -> System.out.println(n));
        }
        System.out.println();
        itr.forEachRemaining(n -> System.out.println(n));


    }
}
