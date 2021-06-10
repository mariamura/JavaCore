package com.mariamura.chapter18;

import java.util.Enumeration;
import java.util.Vector;

public class VectorDemo {
    public static void main(String[] args) {
        Vector<Integer> v = new Vector<>(3,2);
        System.out.println("Initial vector size: " + v.size());
        System.out.println("Initial vector capacity: " + v.capacity());

        v.addElement(1); //can we used add() method instead?
        v.addElement(2);
        v.addElement(3);
        v.addElement(4);

        System.out.println("Vector capacity after adding four elements: " + v.capacity());

        v.addElement(5);
        System.out.println("Vector capacity: " + v.capacity());

        v.addElement(6);
        v.addElement(7);
        System.out.println("Vector capacity: " + v.capacity());

        v.addElement(9);
        v.addElement(10);
        System.out.println("Vector capacity: " + v.capacity());

        v.addElement(11);
        v.addElement(12);
        System.out.println("Vector capacity: " + v.capacity());

        System.out.println("First vector element: "+ v.firstElement());
        System.out.println("Last vector element: " + v.lastElement());

        if(v.contains(3)) System.out.println("Vector contains 3.");

        Enumeration<Integer> vEnum = v.elements();
        System.out.println("\nVector elements:");

        while(vEnum.hasMoreElements()) System.out.print(vEnum.nextElement() + " ");

    }
}
