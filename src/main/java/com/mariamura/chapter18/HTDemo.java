package com.mariamura.chapter18;

import javax.sql.rowset.serial.SerialStruct;
import java.util.Enumeration;
import java.util.Hashtable;

public class HTDemo {
    public static void main(String[] args) {
        Hashtable<String, Double> balance = new Hashtable<>();
        Enumeration<String> names;
        String str;
        double bal;

        balance.put("J Dow", 3434.34);
        balance.put("T Smith", 123.22);
        balance.put("J Baker", 1378.00);
        balance.put("T Holl", 99.22);
        balance.put("R Smith", -19.08);

        names = balance.keys();
        while (names.hasMoreElements()) {
            str = names.nextElement();
            System.out.print(str + ": " + balance.get(str));
            System.out.println();
        }
        System.out.println();

        bal = balance.get("J Dow");
        balance.put("J Dow", bal + 1000);
        System.out.println("New J Dow balance: " + balance.get("J Dow"));



    }
}
