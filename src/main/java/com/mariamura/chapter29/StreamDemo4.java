package com.mariamura.chapter29;

import java.util.ArrayList;
import java.util.stream.Stream;

public class StreamDemo4 {

    public static void main(String[] args) {
        ArrayList<Double> l = new ArrayList<>();
        l.add(7.0);
        l.add(18.0);
        l.add(10.0);
        l.add(24.0);
        l.add(17.0);
        l.add(5.0);
        System.out.println(l);

        Stream<Double> sqrStr = l.stream().map(a -> Math.sqrt(a));
        double sqrStrProd = sqrStr.reduce(1.0, (a,b) -> a*b);

        System.out.println(sqrStrProd);
    }
}
