package com.mariamura.chapter29;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Stream;

public class StreamDemo8 {
    public static void main(String[] args) {
        ArrayList<String> l = new ArrayList<>();
        l.add("Alpha");
        l.add("Beta");
        l.add("Gamma");
        l.add("Delta");
        l.add("Qsi");
        l.add("Omega");

        Stream<String> stream = l.stream();
        Iterator<String> itr = stream.iterator();

        while (itr.hasNext()) System.out.println(itr.next());
    }
}
