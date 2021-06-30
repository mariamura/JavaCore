package com.mariamura.chapter29;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        ArrayList<Integer> l = new ArrayList<>();
        l.add(7);
        l.add(18);
        l.add(10);
        l.add(24);
        l.add(17);
        l.add(5);
        System.out.println(l);

        Stream<Integer> stream = l.stream();
        Optional<Integer> min = stream.min(Integer::compare);
        if(min.isPresent()) System.out.println(min.get());

        stream = l.stream();
        Optional<Integer> max = stream.max(Integer::compare);
        if(max.isPresent()) System.out.println(max.get());

        Stream<Integer> sortStream = l.stream().sorted();
        sortStream.forEach((n) -> System.out.print(n + " "));
        System.out.println();

        Stream<Integer> odd = l.stream().sorted().filter(n -> n%2 == 1);
        odd.forEach(n -> System.out.print(n + " "));
        System.out.println();

        odd = l.stream().sorted().filter(n -> n%2 == 1).filter(n -> n>5);
        odd.forEach(n -> System.out.print(n + " "));
        System.out.println();


    }
}
