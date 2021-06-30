package com.mariamura.chapter29;

import java.util.ArrayList;
import java.util.Optional;

public class StreamDemo2 {
    public static void main(String[] args) {
        ArrayList<Integer> l = new ArrayList<>();
        l.add(7);
        l.add(18);
        l.add(10);
        l.add(24);
        l.add(17);
        l.add(5);
        System.out.println(l);
        Optional<Integer> prod = l.stream().reduce((a, b) -> a*b);
        if(prod.isPresent()) System.out.println(prod.get());

        int prodi = l.stream().reduce(1, (a, b) -> a*b);
        System.out.println(prodi);
    }
}
