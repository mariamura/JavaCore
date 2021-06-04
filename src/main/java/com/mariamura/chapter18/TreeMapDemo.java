package com.mariamura.chapter18;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {
        TreeMap<String, Double> tm = new TreeMap<>();
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
