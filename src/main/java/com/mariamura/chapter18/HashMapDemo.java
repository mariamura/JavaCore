package com.mariamura.chapter18;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {
    public static void main(String[] args) {

        HashMap<String, Double> hm = new HashMap<>();

        hm.put("J Dow", 3434.34);
        hm.put("T Smith", 123.22);
        hm.put("J Baker", 1378.00);
        hm.put("T Holl", 99.22);
        hm.put("R Smith", 19.08);

        Set<Map.Entry<String, Double>> set = hm.entrySet();

        for(Map.Entry<String, Double> me: set) {
            System.out.print(me.getKey() + ": " + me.getValue());
            System.out.println();
        }
            double balance =  hm.get("J Dow");
            hm.put("J Dow", balance + 1000);
            System.out.println("New J Dow balance: "+ hm.get("J Dow"));
    }
}
