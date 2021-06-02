package com.mariamura.chapter18;

/*  add: o(1)
 *  contains: o(n)
 *  next(iterator?): o(h.capacity/n) */

import java.util.HashSet;

public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<>();

        hs.add("Beta");
        hs.add("Alpha");
        hs.add("Gamma");
        hs.add("Omega");

        System.out.println(hs);
    }
}
