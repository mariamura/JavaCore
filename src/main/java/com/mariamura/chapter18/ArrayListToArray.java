package com.mariamura.chapter18;

/*  get: o(1)
 *  add: o(1)
 *  contains: o(n)
 *  remove(0): o(n) */

import java.util.ArrayList;

public class ArrayListToArray {
    public static void main(String[] args) {
        //create ArrayList
        ArrayList<Integer> al = new ArrayList<>();

        //add elements
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);

        System.out.println("al content: " + al);

        //create Array
        Integer[] ar = new Integer[al.size()];
        ar = al.toArray(ar);

        int sum = 0;

        for (int i: ar) sum+=i;

        System.out.println("Sum of ar elements: " + sum);

    }
}
