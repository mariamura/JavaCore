package com.mariamura.chapter18;

import java.util.*;

public class TreeMapDemo2A {
    public static void main(String[] args) {
        CompThenFirstName compLN = new CompThenFirstName();
        Comparator<String> compLastThenFirst = compLN.thenComparing(new CompThenFirstName());

        /* without lambda expression:
         * TreeMap<String, Double> tm = new TreeMap<>(compLastThenFirst); */

        //with lambda method reference
        TreeMap<String, Double> tm = new TreeMap<>(String::compareToIgnoreCase);

        tm.put("J Dow", 3434.34);
        tm.put("T Smith", 123.22);
        tm.put("J Baker", 1378.00);
        tm.put("T Holl", 99.22);
        tm.put("R Smith", 19.08);

        Set<Map.Entry<String, Double>> set = tm.entrySet();

        for (Map.Entry<String, Double> me: set) {
            System.out.print(me.getKey() + ": " + me.getValue());
            System.out.println();
        }

        System.out.println();

        double balance = tm.get("J Dow");
        tm.put("J Dow", balance + 1000);
        System.out.println("New J Dow balance: " + tm.get("J Dow"));
    }
}

class CompLastNames implements Comparator<String> {

    @Override
    public int compare(String aStr, String bStr) {
        int i, j;
        i = aStr.lastIndexOf(' ');
        j = bStr.lastIndexOf(' ');
        return aStr.substring(i).compareToIgnoreCase(bStr.substring(j));
    }
}

class CompThenFirstName implements Comparator<String> {

    @Override
    public int compare(String aStr, String bStr) {
        return aStr.compareToIgnoreCase(bStr);
    }
}
