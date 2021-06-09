package com.mariamura.chapter18;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class AlgorithmsDemo {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();

        ll.add(-8);
        ll.add(20);
        ll.add(-20);
        ll.add(8);

        Comparator<Integer> r = Collections.reverseOrder();

        Collections.sort(ll, r);
        //ll.sort(r) could be used instead

        System.out.print("ll content in reverse order: ");
        for (int i : ll) System.out.print(i + " ");

        System.out.println();

        Collections.shuffle(ll);
        System.out.print("ll content after shuffle: ");
        for (int i : ll) System.out.print(i + " ");

        System.out.println();

        System.out.println("max element " + Collections.max(ll));
        System.out.println("min element " + Collections.min(ll));





    }
}
