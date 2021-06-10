package com.mariamura.chapter18;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class HTDemo2 {
    public static void main(String[] args) {
        Hashtable<String, Double> balance = new Hashtable<>();

        String str;
        double bal;

        balance.put("J Dow", 3434.34);
        balance.put("T Smith", 123.22);
        balance.put("J Baker", 1378.00);
        balance.put("T Holl", 99.22);
        balance.put("R Smith", -19.08);

        Set<String> set = balance.keySet();

        Iterator<String> itr = set.iterator();

        while (itr.hasNext()) {
            str = itr.next();
            System.out.print(str + ": " + balance.get(str) + "\n");

        }

        System.out.println();

        bal = balance.get("J Dow");
        balance.put("J Dow", bal + 1000);
        System.out.println("New J Dow balance: " + balance.get("J Dow"));
    }
}
