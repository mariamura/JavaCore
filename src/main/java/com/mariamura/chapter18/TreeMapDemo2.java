package com.mariamura.chapter18;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapDemo2 {
    public static void main(String[] args) {

        TreeMap<String, Double> tm = new TreeMap<>(new TComp());
        tm.put("J Dow", 3434.34);
        tm.put("T Smith", 122.22);
        tm.put("J Baker", 1378.0);
        tm.put("T Hall", 99.22);
        tm.put("R Smith", -19.08);

        Set<Map.Entry<String, Double>> set = tm.entrySet();

        for (Map.Entry<String, Double> me: set) {
            System.out.println(me.getKey() + ": " + me.getValue());
        }

        System.out.println();

        double balance = tm.get("J Dow");
        tm.put("J Dow", balance + 1000);
        System.out.println("New J Dow balance: " + tm.get("J Dow"));
    }
}

class TComp implements Comparator<String> {

    @Override
    public int compare(String aStr, String bStr) {
        int i, j, k;
        i = aStr.lastIndexOf(' ');
        j = bStr.lastIndexOf(' ');
        k = aStr.substring(i).compareTo(bStr.substring(j));
        if (k == 0) {
            return aStr.compareTo(bStr);
        }
        else return k;
    }
}
