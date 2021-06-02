package com.mariamura.chapter18;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class IteratorDemo {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();

        al.add("C");
        al.add("A");
        al.add("E");
        al.add("B");
        al.add("D");
        al.add("F");

        System.out.print("Initial al content: ");
        Iterator<String> itr = al.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }

        ListIterator<String> litr = al.listIterator();
        while (litr.hasNext()) {
            litr.set(litr.next() + "+");
        }

        System.out.println();

        System.out.print("al content with changes: ");
        litr = al.listIterator();
        while (litr.hasNext()) {
            System.out.print(litr.next() + " ");
        }

        System.out.println();

        System.out.print("Changed al with reverse order: ");
        while (litr.hasPrevious()) {
            System.out.print(litr.previous() + " ");
        }


    }
}
