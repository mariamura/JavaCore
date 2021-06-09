package com.mariamura.chapter18;

import java.util.TreeSet;

public class CompDemo2 {
    public static void main(String[] args) {
        TreeSet<String> ts = new TreeSet<>((aStr, bStr) -> bStr.compareTo(aStr));
        //or we can use Comparator.reverseOrder() instead
        ts.add("C");
        ts.add("A");
        ts.add("B");
        ts.add("E");
        ts.add("F");
        ts.add("D");

        for (String s: ts) {
            System.out.print(s + " ");
        }

        System.out.println();

    }
}
