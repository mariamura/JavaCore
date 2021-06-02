package com.mariamura.chapter18;

/*  get: o(n)
 *  add: o(1)
 *  contains: o(n)
 *  remove(0): o(1) */

import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<>();

        ll.add("F");
        ll.add("B");
        ll.add("D");
        ll.add("E");
        ll.add("C");
        ll.addLast("Z");
        ll.addFirst("A");

        ll.add(1, "A2");

        System.out.println("Initial LinkedList ll content: " + ll);

        ll.remove("F");
        ll.remove(2);

        System.out.println("ll content after elements remove: " + ll);

        ll.removeFirst();
        ll.removeLast();

        System.out.println("ll content after first and last elements remove: " + ll);

        String val = ll.get(2);
        ll.set(2, val + " changed");

        System.out.println("ll content after change: " + ll);


    }
}
