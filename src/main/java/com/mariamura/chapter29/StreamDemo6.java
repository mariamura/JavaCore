package com.mariamura.chapter29;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class StreamDemo6 {
    public static void main(String[] args) {
        ArrayList<Double> l = new ArrayList<>();
        l.add(7.0);
        l.add(18.0);
        l.add(10.0);
        l.add(24.0);
        l.add(17.0);
        l.add(5.0);

        l.stream().forEach(n -> System.out.print(n + " "));
        System.out.println();

        IntStream ctr = l.stream().mapToInt(a -> (int)Math.ceil(a));
        ctr.forEach(n -> System.out.print(n + " "));
    }
}
