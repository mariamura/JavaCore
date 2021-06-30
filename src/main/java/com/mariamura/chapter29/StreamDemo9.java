package com.mariamura.chapter29;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.stream.Stream;

public class StreamDemo9 {
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

        itr.forEachRemaining(n -> System.out.println(n));

        while (itr.tryAdvance(n -> System.out.println(n)));
    }
}
